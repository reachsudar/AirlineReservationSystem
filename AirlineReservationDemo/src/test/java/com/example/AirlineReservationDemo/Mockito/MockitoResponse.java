package com.example.AirlineReservationDemo.Mockito;

import com.example.AirlineReservationDemo.Entities.Flight;
import com.example.AirlineReservationDemo.Entities.Passenger;

import java.util.ArrayList;
import java.util.List;

public class MockitoResponse {
    public static Passenger createPassenger()
    {
        Passenger passenger = new Passenger();
        passenger.setPassportNo("76589");
        passenger.setFirstName("Sample");
        passenger.setLastName("Name");
        passenger.setFlightNo("SQ234");
        passenger.setEMAil("sample@email.com");
        passenger.setPhone("98764435");
        return passenger;
    }

    public static List<Passenger> passengerResponse()
    {
        List<Passenger> list = new ArrayList<>();
        //passenger1
        Passenger passenger1 = new Passenger();
        passenger1.setPassportNo("111111");
        passenger1.setFirstName("First");
        passenger1.setLastName("Name");
        passenger1.setFlightNo("SQ234");
        passenger1.setEMAil("first@email.com");
        passenger1.setPhone("456432");
        list.add(passenger1);
        //passenger2
        Passenger passenger2 = new Passenger();
        passenger2.setPassportNo("222222");
        passenger2.setFirstName("Second");
        passenger2.setLastName("Name");
        passenger2.setFlightNo("SQ456");
        passenger2.setEMAil("second@email.com");
        passenger2.setPhone("467321");
        list.add(passenger2);

        return list;
    }

    public static Flight createFlight()
    {
        Flight flight = new Flight();
        flight.setFlightNo("UA201");
        flight.setAirlines("Emirates");
        flight.setDepartureCity("Sydney");
        flight.setArrivalCity("Mumbai");
        flight.setDateOfDeparture("25-5-2022");
        return flight;
    }

    public static List<Flight> flightResponse()
    {
        List<Flight> list = new ArrayList<>();
        //Flight1
        Flight flight1 = new Flight();
        flight1.setFlightNo("AA111");
        flight1.setAirlines("FirstAirlines");
        flight1.setDepartureCity("Departure1");
        flight1.setArrivalCity("Arrival1");
        flight1.setDateOfDeparture("1-1-2022");
        list.add(flight1);
        //Flight2
        Flight flight2 = new Flight();
        flight2.setFlightNo("AA222");
        flight2.setAirlines("SecondAirlines");
        flight2.setDepartureCity("Departure2");
        flight2.setArrivalCity("Arrival2");
        flight2.setDateOfDeparture("2-2-2022");
        list.add(flight2);

        return list;

    }


}
