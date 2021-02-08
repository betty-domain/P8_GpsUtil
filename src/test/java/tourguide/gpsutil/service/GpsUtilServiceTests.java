package tourguide.gpsutil.service;

import gpsUtil.GpsUtil;
import gpsUtil.location.Attraction;
import gpsUtil.location.Location;
import gpsUtil.location.VisitedLocation;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@SpringBootTest
public class GpsUtilServiceTests {

        @Autowired
        private IGpsUtilService gpsUtilService;

        @MockBean
        private GpsUtil gpsUtilMock;

        @Test
        public void getUserLocationTest()
        {
            UUID userID = new UUID(10,10);

            VisitedLocation visitedLocation = new VisitedLocation(userID,new Location(20d,25d), Date.from(Instant.now()));

            when(gpsUtilMock.getUserLocation(userID)).thenReturn(visitedLocation);

            assertThat(gpsUtilService.getUserLocation(userID)).isNotNull();
        }

        @Test
        public void getAllAttractionsTest()
        {
            List<Attraction> attractionList = new ArrayList<>();
            Attraction attraction1 = new Attraction("attraction1","city1","state1",10d,15d);
            Attraction attraction2 = new Attraction("attraction2","city2","state2",25d,35d);

            attractionList.add(attraction1);
            attractionList.add(attraction2);

            when(gpsUtilMock.getAttractions()).thenReturn(attractionList);

            assertThat(gpsUtilService.getAttractions()).isNotEmpty();
        }
}
