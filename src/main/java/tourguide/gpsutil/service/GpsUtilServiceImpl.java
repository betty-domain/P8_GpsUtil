package tourguide.gpsutil.service;

import gpsUtil.GpsUtil;
import gpsUtil.location.Attraction;
import gpsUtil.location.VisitedLocation;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tourguide.gpsutil.controller.GpsUtilController;

import java.util.List;
import java.util.Locale;
import java.util.UUID;

/**
 * GpsUtilService Implementation to interact with GpsUtil external lib
 */
@Service
public class GpsUtilServiceImpl implements IGpsUtilService{
    private static final Logger logger = LogManager.getLogger(GpsUtilServiceImpl.class);

    @Autowired
    private GpsUtil gpsUtil;

    /**
     * Default Constructor
     */
    public GpsUtilServiceImpl()
    {
        Locale.setDefault(Locale.US);
    }

    /**
     * getUserLocation for a given user
     * @param userId userId
     * @return get VisitedLocation for given user
     */
    public VisitedLocation getUserLocation(UUID userId)
    {
        logger.debug("Call to gpsUtil.getUSerLocation(" + userId + ")");
        return gpsUtil.getUserLocation(userId);
    }

    /**
     * get list of all Attractions
     *
     * @return list of attractions
     */
    public List<Attraction> getAttractions()
    {
        logger.debug("Call to gpsUtil.getAttractions()");
        return gpsUtil.getAttractions();
    }
}


