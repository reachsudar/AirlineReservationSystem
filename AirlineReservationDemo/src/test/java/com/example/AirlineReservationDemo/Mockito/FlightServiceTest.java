package com.example.AirlineReservationDemo.Mockito;


import com.example.AirlineReservationDemo.Controllers.FlightController;
import com.example.AirlineReservationDemo.Entities.Flight;
import com.example.AirlineReservationDemo.Repositories.FlightRepository;
import com.example.AirlineReservationDemo.Services.FlightService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@WebMvcTest(FlightServiceTest.class)
public class FlightServiceTest {

    @InjectMocks
    private FlightController flightController;
    @Mock
    private FlightService flightService;
    @Mock
    private FlightRepository flightRepository;

    private Flight flight=null;

    @BeforeEach
    public void init()
    {
        flight = MockitoResponse.createFlight();
    }

    @Test
    public void testGetAll()
    {
        Mockito.when(flightService.getAll()).thenReturn(MockitoResponse.flightResponse());
        ResponseEntity<Flight> result = (ResponseEntity<Flight>) flightController.checkFlights();
        Assert.assertEquals(200,result.getStatusCodeValue());
    }

    @Test
    public void testGetById()
    {
        Mockito.when(flightService.getById(Mockito.anyString())).thenReturn(flight);
        ResponseEntity<Flight> result = (ResponseEntity<Flight>) flightController.checkFlight(Mockito.anyString());
        Assert.assertEquals(200,result.getStatusCodeValue());

    }
    @Test
    public void testSave()
    {
        Mockito.when(flightService.save(Mockito.any(Flight.class))).thenReturn(MockitoResponse.createFlight());
        Assert.assertEquals(flight,flightService.save(flight));
    }

    @Test
    public void testUpdate()
    {
        Mockito.when(flightService.update(Mockito.anyString(),Mockito.any(Flight.class))).thenReturn(MockitoResponse.createFlight());
        Assert.assertEquals(flight,flightService.update("AA111",flight));
    }

    @Test
    public void testDelete()
    {
        Mockito.when(flightService.getById(Mockito.anyString())).thenReturn(flight);
        flightService.delete("AA111");
        Assert.assertNull(flight);
    }

}
