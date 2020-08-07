package controlador;

import contexto.ContextoCita;
import contexto.ContextoUsuario;
import dao.DiagnosticoDAO;
import formulario.PacienteCitasAsociadas;
import generico.Tabla;
import java.sql.SQLException;
import java.util.Map;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author Muro
 */

@Controller
@RequestMapping(value = "/realizarTratamiento")
public class RealizarTratamiento {
  
//  @RequestMapping(method = RequestMethod.GET)
//  public String viewFiltroCitasPaciente(Map<String, Object> model) {
//    PacienteCitasAsociadas form = new PacienteCitasAsociadas();
//    model.put("citasAsociadasPacForm", form);
//    loadTable("", "", "", "", ContextoUsuario.getIdUsuario(), model);
//    return "citasAsociadasPaciente";
//  }
//  
//  private void loadTable(Map<String, Object> model) {
//    try {     
//      Tabla<TablaTratamiento> resultados = DiagnosticoDAO.obtenerDiagnosticos(ContextoCita.getIdCita());
//      model.put("resultados", resultados);     
//    } catch (SQLException ex) {
//      ex.printStackTrace();
//    }
//  }
}
