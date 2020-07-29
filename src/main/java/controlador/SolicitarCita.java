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
      //solicitarCita(cita.getEspecialidad(), cita.getFecha(), cita.getHora(), cita.getObservacion(),)
      System.out.println(cita.getEspecialidad());
      System.out.println(cita.getFecha());
      System.out.println(cita.getHora()); 
      System.out.println(cita.getObservacion());
      model.put("usuario", ContextoUsuario.getUsuario());
      model.put("tipo", ContextoUsuario.getTipo());
      return "menu";
    }
    
    
    private void solicitarCita(String pEspecialidad, String pFechaHora, String pObservacion, int idPaciente) {
      try{
        CitaDAO.anadirCita(pEspecialidad, pFechaHora, pObservacion, idPaciente);
      } catch(SQLException e){
        e.printStackTrace();
      }
    }
    
}
