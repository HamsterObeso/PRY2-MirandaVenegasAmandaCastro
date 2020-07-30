/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.util.Map;
import modelo.Cita;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author Masiel Castro Mora
 */
@Controller
@RequestMapping(value = "/cancelarCitaFuncionario")
public class cancelarCitaFuncionario {
    
    @RequestMapping(method = RequestMethod.GET)
    public String viewCancelarCitaP(Map<String, Object> model) {
      Cita cita = new Cita();
      model.put("cancelarCitaFForm", cita);
      return "cancelarCitaFuncionario";
    }
    
    @RequestMapping(method = RequestMethod.POST)  
    public String cancelarCitaP(@ModelAttribute("cancelarCitaFForm") Cita cita,
        Map<String, Object> model) {
      //cancelarCita(cita.getIdCita(), ContextoUsuario.getIdUsuario())
      System.out.println(cita.getIdCita());
      return "menu";
    }
    
}
