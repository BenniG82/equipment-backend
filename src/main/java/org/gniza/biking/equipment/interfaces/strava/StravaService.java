package org.gniza.biking.equipment.interfaces.strava;

import javastrava.api.v3.auth.AuthorisationService;
import javastrava.api.v3.auth.impl.retrofit.AuthorisationServiceImpl;
import javastrava.api.v3.auth.model.Token;
import javastrava.api.v3.model.StravaActivity;
import javastrava.api.v3.model.StravaAthlete;
import javastrava.api.v3.model.reference.StravaMeasurementMethod;
import javastrava.api.v3.service.Strava;
import javastrava.api.v3.service.exception.BadRequestException;
import javastrava.util.Paging;
import org.gniza.biking.equipment.AuthorizationException;
import org.gniza.biking.equipment.graphmodel.*;
import org.gniza.biking.equipment.repository.ActivityRepository;
import org.gniza.biking.equipment.repository.AthleteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Component
public class StravaService {

    private static final Integer PAGE_SIZE = 200;
    @Value(value = "${strava.app.id}")
    private int applicationId;
    @Value(value = "${strava.app.secret}")
    private String applicationSecret;
    @Value(value = "${strava.app.testToken}")
    private String userToken;

    @Autowired
    AthleteRepository athleteRepository;
    @Autowired
    ActivityRepository activRepository;

    private static Athlete convert(StravaAthlete stravaAthlete) {
        Athlete a = new Athlete();
        a.setCity(stravaAthlete.getCity());
        a.setCountry(stravaAthlete.getCountry());
        a.setCreatedAt(stravaAthlete.getCreatedAt());
        a.setEmail(stravaAthlete.getEmail());
        a.setExternalId(String.valueOf(stravaAthlete.getId()));
        a.setFirstname(stravaAthlete.getFirstname());
        a.setLastname(stravaAthlete.getLastname());
        a.setMeasurementPreference(convert(stravaAthlete.getMeasurementPreference()));
        a.setPremium(stravaAthlete.getPremium());
        a.setProfile(stravaAthlete.getProfile());
        a.setProfileMedium(stravaAthlete.getProfileMedium());
        a.setSex(SexEnum.valueOf(stravaAthlete.getSex().getValue().toUpperCase()));
        a.setSourceSystem(SourceSystemEnum.STRAVA);
        a.setUpdatedAt(stravaAthlete.getUpdatedAt());

        return a;
    }

    private static MeasurementPreferenceEnum convert(StravaMeasurementMethod measurementPreference) {
        return MeasurementPreferenceEnum.valueOf(measurementPreference.getValue().toUpperCase());
    }

    private static Activity convert(StravaActivity activity, Athlete athlete) {

        Activity a = new Activity();
        a.setAchievementCount(activity.getAchievementCount());
        a.setAverageCadence(activity.getAverageCadence());
        a.setAverageHeartrate(activity.getAverageHeartrate());
        a.setAverageSpeed(activity.getAverageSpeed());
        a.setAverageTemp(activity.getAverageTemp());
        a.setAverageWatts(activity.getAverageWatts());
        a.setCommute(activity.getCommute());
        a.setDeviceWatts(activity.getDeviceWatts());
        a.setDistanceMeters(activity.getDistance());
        a.setElapsedTimeSeconds(activity.getElapsedTime());
        a.setExternalId(String.valueOf(activity.getId()));
        a.setFlagged(activity.getFlagged());
        //FIXME Benni: gear-verwaltung
        //a.setGearId(activity.getGear());
        a.setKilojoules(activity.getKilojoules());
        a.setLocationCity(activity.getLocationCity());
        a.setLocationCountry(activity.getLocationCountry());
        a.setLocationState(activity.getLocationState());
        a.setManual(activity.getManual());
        //FIXME Benni: MAP
        //a.setMap(activity.getMap());
        a.setMaxHeartrate(activity.getMaxHeartrate());
        a.setMaxSpeed(activity.getMaxSpeed());
        a.setMovingTimeSeconds(activity.getMovingTime());
        a.setName(activity.getName());
        a.setPrivateActivity(activity.getPrivateActivity());
        a.setSourceSystem(SourceSystemEnum.STRAVA);
        a.setStartDateLocal(activity.getStartDateLocal());
        a.setStartDateUtc(activity.getStartDate());
        a.setTotalElevationGainMeters(activity.getTotalElevationGain());
        a.setTrainer(activity.getTrainer());
//        a.setType(activity.getType().getValue());
        a.setWeightedAverageWatts(activity.getWeightedAverageWatts());

        a.setAthlete(athlete);
        athlete.getActivities().add(a);
        return a;
    }

    private Collection<Activity> convert(Collection<StravaActivity> activities, Athlete athlete) {
        List<Activity> convertedActivities = new ArrayList<>();
        for (StravaActivity activity : activities) {
            Activity a = convert(activity, athlete);
            convertedActivities.add(a);
        }
        return convertedActivities;

    }

    private Strava authenticate(String userToken) {

        AuthorisationService service = new AuthorisationServiceImpl();
        try {
            Token token = service.tokenExchange(applicationId,
                    applicationSecret,
                    userToken);
            return new Strava(token);
        } catch (BadRequestException e) {
            throw new AuthorizationException(e);
        }
    }

    public Athlete getCurrentAthlete(String userToken) {
        Strava strava = authenticate(userToken);
        StravaAthlete stravaAthlete = strava.getAuthenticatedAthlete();
        return convert(stravaAthlete);
    }

    public Collection<Activity> getActivities(String userToken, Athlete athlete, int page) {
        Strava strava = authenticate(userToken);
        Paging paging = new Paging(page, PAGE_SIZE);
        Collection<StravaActivity> activities = strava.listAuthenticatedAthleteActivities();
        return convert(activities, athlete);
    }

    //@PostConstruct
    @Transactional
    public void run() throws Exception {
        Strava strava = authenticate(userToken);
        StravaAthlete stravaAthlete = strava.getAuthenticatedAthlete();
        System.out.println(stravaAthlete.getEmail());
        Paging paging = new Paging();
        paging.setPage(0);
        paging.setPageSize(200);
        Athlete athlete = convert(stravaAthlete);
        List<StravaActivity> stravaActivities = strava.listAuthenticatedAthleteActivities(paging);
        List<Activity> activities = new ArrayList<>();
        for (StravaActivity activity : stravaActivities) {
            Activity a = convert(activity, athlete);
            activities.add(a);
        }

        athleteRepository.save(athlete);
        activRepository.save(activities);
        System.out.println("Added " + activities.size() + " Activities");
    }
}
