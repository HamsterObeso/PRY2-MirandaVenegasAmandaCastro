/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import contexto.ContextoUsuario;
import dao.CitaDAO;
import dao.FuncionarioDAO;
import java.sql.SQLException;
import java.util.Map;
import modelo.Cita;
import modelo.Funcionario;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
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
    
    @RequestMapping(method = RequestMethod.POST)  
    public String asinarCita(@ModelAttribute("patientForm") Cita cita,
      Map<String, Object> model) {
    try {
      CitaDAO.asignarCita(cita.getIdCita(),ContextoUsuario.getIdUsuario());
      model.put("cita", "cita");
    } catch(SQLException e){
      model.put("error", "error");
      e.printStackTrace();
    }
    return "asignarCita";
  }
    
}
