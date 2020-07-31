package controlador;

import conexion.Service;
import conexion.SmsRequest;
import contexto.ContextoUsuario;
import dao.CitaDAO;
import java.sql.SQLException;
import java.util.Map;
import javax.validation.Valid;
import modelo.Cita;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import controlador.MensajeControlador;

/**
 *
 * @author Muro
 */

@Controller
@RequestMapping(value = "/cancelarCita")
public class CancelarCita {
    
  @RequestMapping(method = RequestMethod.GET)
  public String viewCancelarCitaP(Map<String, Object> model) {
    Cita cita = new Cita();
    model.put("cancelarCitaPacForm", cita);
    return "cancelarCitaPaciente";
  }

  @RequestMapping(method = RequestMethod.POST)  
  public String cancelarCitaP(@ModelAttribute("cancelarCitaPacForm") Cita cita,
      Map<String, Object> model) {
    try {
      if(ContextoUsuario.getTipo().equals("Paciente")){
        CitaDAO.cancelarCitaPaciente(cita.getIdCita(), ContextoUsuario.getIdUsuario());
      } else {
        CitaDAO.cancelarCitaFuncionario(cita.getIdCita(), ContextoUsuario.getIdUsuario());
      }
      model.put("cita", "cita");
    } catch(SQLException e){
      model.put("error", "error");
      e.printStackTrace();
    }
    return "cancelarCitaPaciente";
    
        }
 

}
 


