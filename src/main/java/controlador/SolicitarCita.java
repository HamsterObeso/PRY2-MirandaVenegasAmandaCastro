package controlador;

import contexto.ContextoUsuario;
import dao.CitaDAO;
import java.sql.SQLException;
import java.util.Map;
import modelo.Cita;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author Muro
 */
@Controller
@RequestMapping(value = "/solicitarCita")
public class SolicitarCita {
    
    @RequestMapping(method = RequestMethod.GET)
    public String viewSolicitarCita(Map<String, Object> model) {
      Cita cita = new Cita();
      model.put("patientForm", cita);
      return "solicitarCita";
    }
    
    @RequestMapping(method = RequestMethod.POST)  
    public String validarInicioSesion(@ModelAttribute("patientForm") Cita cita,
        Map<String, Object> model) {
      solicitarCita(cita.getEspecialidad(), cita.getFecha(), cita.getHora(), cita.getObservacion(), ContextoUsuario.getIdUsuario());
      model.put("cita", "cita");
      return "solicitarCita";
    }   
    
    private void solicitarCita(String pEspecialidad, String pFecha, String pHora, String pObservacion, int idPaciente) {
      try {
        CitaDAO.anadirCita(pEspecialidad, pFecha, pHora, pObservacion, idPaciente);
      } catch(SQLException e){
        e.printStackTrace();
      }
    }
    
}
