package org.gniza.biking.equipment.repository;


import com.google.common.base.Stopwatch;
import org.gniza.biking.equipment.TestConfig;
import org.gniza.biking.equipment.graphmodel.Athlete;
import org.gniza.biking.equipment.graphmodel.SourceSystemEnum;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.concurrent.TimeUnit;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = TestConfig.class)
public class NeoTest {
    @Autowired
    private AthleteRepository athleteRepository;

    @Test
    public void testGetAthlete() {
        Stopwatch sw = Stopwatch.createStarted();
        Athlete athlete = athleteRepository.findByExternalIdAndSourceSystem("1681507", SourceSystemEnum.STRAVA);
        sw.stop();
        System.out.println(athlete.getFirstname());
        System.out.println(athlete.getActivities().size());
        System.out.println(sw.elapsed(TimeUnit.MILLISECONDS));
    }
}
