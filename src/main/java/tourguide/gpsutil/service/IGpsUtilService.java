package tourguide.gpsutil.service;

import gpsUtil.location.Attraction;
import gpsUtil.location.VisitedLocation;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

/**
 * Interface of GpsUtilService
 */
public interface IGpsUtilService {
    /**
     * getUserLocation for a given user
     * @param userId userId
     * @return get VisitedLocation for given user
     */
    VisitedLocation getUserLocation(UUID userId);

    /**
     * get list of all Attractions
     *
     * @return list of attractions
     */
    List<Attraction> getAttractions();

}
