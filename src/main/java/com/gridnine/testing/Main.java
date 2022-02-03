package com.gridnine.testing;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Flight> groupFlight = FlightBuilder.createFlights();

        System.out.println("Вылеты до текущего момента времени: ");
        FilterFlight flightArrivalDateEarlierDepartureDateImpl =
                new FlightArrivalDateEarlierDepartureDateImpl();
        System.out.println(flightArrivalDateEarlierDepartureDateImpl.filterFlight(groupFlight));

        System.out.println("Вылеты, где имеются сегменты с датой прилёта раньше даты вылета: ");
        FilterFlight flightBeforeCurrentTimeImpl = new FlightBeforeCurrentTimeImpl();
        System.out.println(flightBeforeCurrentTimeImpl.filterFlight(groupFlight));

        System.out.println("Вылеты, где общее время, проведённое на земле превышает два часа: ");
        FilterFlight flightWhereTimeOnEarthMoreTwoHours = new FlightWhereTimeOnEarthMoreTwoHoursImpl();
        System.out.println(flightWhereTimeOnEarthMoreTwoHours.filterFlight(groupFlight));
    }
}
