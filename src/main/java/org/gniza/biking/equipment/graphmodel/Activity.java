package org.gniza.biking.equipment.graphmodel;

import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

import java.time.LocalDateTime;
import java.time.ZonedDateTime;

@NodeEntity
public class Activity {
    @GraphId
    private Long id;

    private String externalId;
    private SourceSystemEnum sourceSystem;
    @Relationship(type = "ACTIVITY", direction = Relationship.INCOMING)
    private Athlete athlete;
    private String name;
    private Number distanceMeters;
    private Integer movingTimeSeconds;
    private Integer elapsedTimeSeconds;
    private Number totalElevationGainMeters;
    private String type;
    private ZonedDateTime startDateUtc;
    private LocalDateTime startDateLocal;
    //private List<Number> startLatlng = new ArrayList<Number>();
    //private List<Number> endLatlng = new ArrayList<Number>();
    private String locationCity;
    private String locationState;
    private String locationCountry;
    private Number startLatitude;
    private Number startLongitude;
    private Integer achievementCount;
    private String map;
    private Boolean trainer;
    private Boolean commute;
    private Boolean manual;
    private Boolean privateActivity;
    private Boolean flagged;
    private SourceSystemEquipment gearId;
    private Number averageSpeed;
    private Number maxSpeed;
    private Number averageCadence;
    private Number averageTemp;
    private Number averageWatts;
    private Number weightedAverageWatts;
    private Number kilojoules;
    private Boolean deviceWatts;
    private Number averageHeartrate;
    private Integer maxHeartrate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getExternalId() {
        return externalId;
    }

    public void setExternalId(String externalId) {
        this.externalId = externalId;
    }

    public SourceSystemEnum getSourceSystem() {
        return sourceSystem;
    }

    public void setSourceSystem(SourceSystemEnum sourceSystem) {
        this.sourceSystem = sourceSystem;
    }

    public Athlete getAthlete() {
        return athlete;
    }

    public void setAthlete(Athlete athlete) {
        this.athlete = athlete;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Number getDistanceMeters() {
        return distanceMeters;
    }

    public void setDistanceMeters(Number distanceMeters) {
        this.distanceMeters = distanceMeters;
    }

    public Integer getMovingTimeSeconds() {
        return movingTimeSeconds;
    }

    public void setMovingTimeSeconds(Integer movingTimeSeconds) {
        this.movingTimeSeconds = movingTimeSeconds;
    }

    public Integer getElapsedTimeSeconds() {
        return elapsedTimeSeconds;
    }

    public void setElapsedTimeSeconds(Integer elapsedTimeSeconds) {
        this.elapsedTimeSeconds = elapsedTimeSeconds;
    }

    public Number getTotalElevationGainMeters() {
        return totalElevationGainMeters;
    }

    public void setTotalElevationGainMeters(Number totalElevationGainMeters) {
        this.totalElevationGainMeters = totalElevationGainMeters;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public ZonedDateTime getStartDateUtc() {
        return startDateUtc;
    }

    public void setStartDateUtc(ZonedDateTime startDateUtc) {
        this.startDateUtc = startDateUtc;
    }

    public LocalDateTime getStartDateLocal() {
        return startDateLocal;
    }

    public void setStartDateLocal(LocalDateTime startDateLocal) {
        this.startDateLocal = startDateLocal;
    }

    public String getLocationCity() {
        return locationCity;
    }

    public void setLocationCity(String locationCity) {
        this.locationCity = locationCity;
    }

    public String getLocationState() {
        return locationState;
    }

    public void setLocationState(String locationState) {
        this.locationState = locationState;
    }

    public String getLocationCountry() {
        return locationCountry;
    }

    public void setLocationCountry(String locationCountry) {
        this.locationCountry = locationCountry;
    }

    public Number getStartLatitude() {
        return startLatitude;
    }

    public void setStartLatitude(Number startLatitude) {
        this.startLatitude = startLatitude;
    }

    public Number getStartLongitude() {
        return startLongitude;
    }

    public void setStartLongitude(Number startLongitude) {
        this.startLongitude = startLongitude;
    }

    public Integer getAchievementCount() {
        return achievementCount;
    }

    public void setAchievementCount(Integer achievementCount) {
        this.achievementCount = achievementCount;
    }

    public String getMap() {
        return map;
    }

    public void setMap(String map) {
        this.map = map;
    }

    public Boolean getTrainer() {
        return trainer;
    }

    public void setTrainer(Boolean trainer) {
        this.trainer = trainer;
    }

    public Boolean getCommute() {
        return commute;
    }

    public void setCommute(Boolean commute) {
        this.commute = commute;
    }

    public Boolean getManual() {
        return manual;
    }

    public void setManual(Boolean manual) {
        this.manual = manual;
    }

    public Boolean getPrivateActivity() {
        return privateActivity;
    }

    public void setPrivateActivity(Boolean privateActivity) {
        this.privateActivity = privateActivity;
    }

    public Boolean getFlagged() {
        return flagged;
    }

    public void setFlagged(Boolean flagged) {
        this.flagged = flagged;
    }

    public SourceSystemEquipment getGearId() {
        return gearId;
    }

    public void setGearId(SourceSystemEquipment gearId) {
        this.gearId = gearId;
    }

    public Number getAverageSpeed() {
        return averageSpeed;
    }

    public void setAverageSpeed(Number averageSpeed) {
        this.averageSpeed = averageSpeed;
    }

    public Number getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(Number maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    public Number getAverageCadence() {
        return averageCadence;
    }

    public void setAverageCadence(Number averageCadence) {
        this.averageCadence = averageCadence;
    }

    public Number getAverageTemp() {
        return averageTemp;
    }

    public void setAverageTemp(Number averageTemp) {
        this.averageTemp = averageTemp;
    }

    public Number getAverageWatts() {
        return averageWatts;
    }

    public void setAverageWatts(Number averageWatts) {
        this.averageWatts = averageWatts;
    }

    public Number getWeightedAverageWatts() {
        return weightedAverageWatts;
    }

    public void setWeightedAverageWatts(Number weightedAverageWatts) {
        this.weightedAverageWatts = weightedAverageWatts;
    }

    public Number getKilojoules() {
        return kilojoules;
    }

    public void setKilojoules(Number kilojoules) {
        this.kilojoules = kilojoules;
    }

    public Boolean getDeviceWatts() {
        return deviceWatts;
    }

    public void setDeviceWatts(Boolean deviceWatts) {
        this.deviceWatts = deviceWatts;
    }

    public Number getAverageHeartrate() {
        return averageHeartrate;
    }

    public void setAverageHeartrate(Number averageHeartrate) {
        this.averageHeartrate = averageHeartrate;
    }

    public Integer getMaxHeartrate() {
        return maxHeartrate;
    }

    public void setMaxHeartrate(Integer maxHeartrate) {
        this.maxHeartrate = maxHeartrate;
    }
}