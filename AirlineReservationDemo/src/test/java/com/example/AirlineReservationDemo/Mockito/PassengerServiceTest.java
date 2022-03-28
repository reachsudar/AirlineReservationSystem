package com.example.AirlineReservationDemo.Mockito;

import com.example.AirlineReservationDemo.APIResponse.APIResponse;
import com.example.AirlineReservationDemo.Controllers.PassengerController;
import com.example.AirlineReservationDemo.Entities.Passenger;
import com.example.AirlineReservationDemo.Repositories.PassengerRepository;
import com.example.AirlineReservationDemo.Services.PassengerService;
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
@WebMvcTest(value = PassengerServiceTest.class)
@SuppressWarnings("all")
public class PassengerServiceTest {

    @InjectMocks
    private PassengerController passengerController;
    @Mock
    private PassengerService passengerService;
    @Mock
    private PassengerRepository passengerRepository;
    private Passenger passenger = null;
    @Mock
    private APIResponse apiResponse;

    @BeforeEach
    public void init()
    {
        passenger = MockitoResponse.createPassenger();
    }

    @Test
    public void testGetAll()
    {
        Mockito.when(passengerService.getall()).thenReturn(MockitoResponse.passengerResponse());
        ResponseEntity<Passenger> response = (ResponseEntity<Passenger>)passengerController.viewPassengers();
        Assert.assertEquals(200,response.getStatusCodeValue());

    }

    @Test
    public void testSave()
    {
         Mockito.when(passengerService.save(Mockito.any(Passenger.class))).thenReturn(MockitoResponse.createPassenger());
         Assert.assertEquals(passenger,passengerService.save(passenger));

    }

    @Test
    public void testGetById()
    {
        Mockito.when(passengerService.getById(Mockito.anyString())).thenReturn(passenger);
        ResponseEntity<Passenger> response = (ResponseEntity<Passenger>)passengerController.viewById(Mockito.anyString());
        Assert.assertEquals(200,response.getStatusCodeValue());

    }

    @Test
    public void testUpdate()
    {
        Mockito.when(passengerService.update(Mockito.anyString(),Mockito.any(Passenger.class))).thenReturn(passenger);
        Assert.assertEquals(passenger,passengerService.update("76589",passenger));
    }

    @Test
    public void testDelete()
    {
        Mockito.when(passengerService.getById(Mockito.anyString())).thenReturn(passenger);
        passengerService.delete("76589");
        Assert.assertNull(passenger);
    }


}
