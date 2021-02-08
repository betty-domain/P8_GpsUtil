package tourguide.gpsutil.controller;

import gpsUtil.location.Attraction;
import gpsUtil.location.Location;
import gpsUtil.location.VisitedLocation;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import tourguide.gpsutil.service.IGpsUtilService;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.CopyOnWriteArrayList;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = GpsUtilController.class)
public class GpsUtilControllerTests {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private IGpsUtilService gpsUtilServiceMock;

    @Test
    public void getUserLocationTest() throws Exception
    {
        UUID userID = new UUID(10,10);

        VisitedLocation visitedLocation = new VisitedLocation(userID,new Location(20d,25d),Date.from(Instant.now()));

        when(gpsUtilServiceMock.getUserLocation(userID)).thenReturn(visitedLocation);

        MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.get("/userLocation").
                contentType(MediaType.APPLICATION_JSON).param("userId",userID.toString());

        mockMvc.perform(builder).
                andExpect(status().isOk()).
                andExpect(jsonPath("userId").value(userID.toString()));
    }

    @Test
    public void getAllAttractionsTest() throws Exception
    {
        List<Attraction> attractionList = new ArrayList<>();
        Attraction attraction1 = new Attraction("attraction1","city1","state1",10d,15d);
        Attraction attraction2 = new Attraction("attraction2","city2","state2",25d,35d);

        attractionList.add(attraction1);
        attractionList.add(attraction2);

        when(gpsUtilServiceMock.getAttractions()).thenReturn(attractionList);

        MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.get("/attractions").
                contentType(MediaType.APPLICATION_JSON);

        mockMvc.perform(builder).
                andExpect(status().isOk()).
                andExpect(jsonPath("$").isArray()).
                andExpect(jsonPath("$[0].attractionName").value(attraction1.attractionName));
    }
}
