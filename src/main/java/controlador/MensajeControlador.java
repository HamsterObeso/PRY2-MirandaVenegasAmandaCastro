package controlador;

import conexion.SmsRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import conexion.Service;

import javax.validation.Valid;


@RestController
@RequestMapping("api/v1/sms")
public class MensajeControlador {

    private final Service service;

    @Autowired
    public MensajeControlador(Service service) {
        this.service = service;
    }


    public void sendSms(@Valid @RequestBody SmsRequest smsRequest) {
        service.sendSms(smsRequest);
    }
}
