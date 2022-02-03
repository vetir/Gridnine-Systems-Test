package com.gridnine.testing;

import java.util.List;
import java.util.stream.Collectors;

public class FlightArrivalDateEarlierDepartureDateImpl implements FilterFlight{

    @Override
    public List<Flight> filterFlight(List<Flight> flightList) {
        return flightList.stream()
                .filter(flight -> flight.getSegments().stream()
                        .anyMatch(segment -> segment.getArrivalDate().isBefore(segment.getDepartureDate())))
                .collect(Collectors.toList());
    }
}
