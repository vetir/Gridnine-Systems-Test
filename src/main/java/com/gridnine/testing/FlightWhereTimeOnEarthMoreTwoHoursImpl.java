package com.gridnine.testing;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.stream.Collectors;

public class FlightWhereTimeOnEarthMoreTwoHoursImpl implements FilterFlight {

    static final Long TOO_MUCH_TIME_ON_LAND = 2L;

    @Override
    public List<Flight> filterFlight(List<Flight> flightList) {
        return flightList.stream()
                .filter(flight -> segmentsWithTimeOnLandMore2Hours(flight.getSegments()))
                .collect(Collectors.toList());
    }

    private Boolean segmentsWithTimeOnLandMore2Hours(List<Segment> segments) {
        Long currentTimeOnLand = 0L;
        for (int i = 0; i < segments.size() - 1; i++) {
            currentTimeOnLand += timeOnLand(segments.get(i), segments.get(i + 1));
        }
        return currentTimeOnLand > TOO_MUCH_TIME_ON_LAND;
    }

    private Long timeOnLand(Segment arrival, Segment departure) {
        return ChronoUnit.HOURS.between(arrival.getArrivalDate(), departure.getDepartureDate());
    }
}
