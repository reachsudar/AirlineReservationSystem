package com.example.AirlineReservationDemo.SMSNotificaton;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

@org.springframework.stereotype.Service
public class SmsService {

    private final SmsSender SmsSender;
    @Autowired
    public SmsService(@Qualifier("twilio") TwilioSmsSender twilioSmsSender)
    {
        this.SmsSender = twilioSmsSender;
    }

    public void sendSms(SmsRequest smsRequest)
    {
        SmsSender.sendSms(smsRequest);
    }

}
