package controlador;

import contexto.ContextoUsuario;
import dao.CatalogoDiagnosticoDAO;
import dao.CitaDAO;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;
import modelo.TablaCancelarCita;
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
@RequestMapping(value = "/cancelarCita")
public class CancelarCita {
  
  @RequestMapping(method = RequestMethod.GET)
  public String viewCancelarCitaP(Map<String, Object> model) {
    Cita cita = new Cita();
    model.put("cancelarCitaPacForm", cita);
    loadTable(model);
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
    loadTable(model);
    return "redirect:/cancelarCitaPaciente";
  }
  
  private void loadTable(Map<String, Object> model) {
    try {     
      ArrayList<TablaCancelarCita> resultados = CitaDAO.obtenerCitasCancelarPaciente(ContextoUsuario.getIdUsuario());
      model.put("resultados", resultados);     
    } catch (SQLException ex) {
      ex.printStackTrace();
    }
  }
}
