package com.example.AirlineReservationDemo.SMSNotificaton;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("sms/v1")
public class SmsController {

    private final SmsService smsService;

    @Autowired
    public SmsController(SmsService smsService)
    {
        this.smsService = smsService;
    }

    @PostMapping
    public void setSmsService(@RequestBody SmsRequest smsRequest)
    {
        smsService.sendSms(smsRequest);
    }

}
