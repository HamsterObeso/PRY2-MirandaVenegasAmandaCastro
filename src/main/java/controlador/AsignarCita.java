/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.util.Map;
import modelo.Cita;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author Masiel Castro Mora
 */
@Controller
@RequestMapping(value = "/asignarCita")
public class AsignarCita {
    
    @RequestMapping(method = RequestMethod.GET)
    public String viewSolicitarCita(Map<String, Object> model) {
      Cita cita = new Cita();
      model.put("patientForm", cita);
      return "asignarCita";
    }
    
}
