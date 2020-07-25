/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author Muro
 */
@Controller public class PacienteControlador {
    @RequestMapping(value="/paciente", method = RequestMethod.GET)
    public String viewPaciente(){
        return "paciente";
    }
}
