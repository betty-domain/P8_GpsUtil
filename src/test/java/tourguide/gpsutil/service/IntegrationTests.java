package tourguide.gpsutil.service;

import gpsUtil.location.Attraction;
import gpsUtil.location.VisitedLocation;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;


@SpringBootTest
public class IntegrationTests {

    @Autowired
    private IGpsUtilService gpsUtilService;

    @Test
    public void getUserLocationTest()
    {
        UUID userID = new UUID(10,10);

        VisitedLocation visitedLocation = gpsUtilService.getUserLocation(userID);

        assertThat(visitedLocation).isNotNull();
        assertThat(visitedLocation.userId).isEqualTo(userID);
    }

    @Test
    public void getAllAttractionsTest()
    {
        List<Attraction> attractionList = gpsUtilService.getAttractions();

        assertThat(attractionList).isNotEmpty();
    }

}
