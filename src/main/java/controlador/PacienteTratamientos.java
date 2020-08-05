package controlador;

import contexto.ContextoUsuario;

import dao.CitaDAO;
import dao.TratamientoDAO;

import formulario.PacienteTratamientosAsociados;

import generico.Tabla;

import java.sql.SQLException;

import java.util.Map;

import modelo.TablaTratamientosPaciente;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author Muro
 */

@Controller
@RequestMapping(value = "/tratamientosPaciente")
public class PacienteTratamientos {
  
  @RequestMapping(method = RequestMethod.GET)
  public String viewFiltroTratamientosPaciente(Map<String, Object> model) {
    PacienteTratamientosAsociados form = new PacienteTratamientosAsociados();
    model.put("tratamientosAsociadosPacForm", form);
    loadTable("", "", "", "", ContextoUsuario.getIdUsuario(), model);
    return "tratamientosAsociadosPaciente";
  }
    
  @RequestMapping(method = RequestMethod.POST)  
  public String filtroTratamientosPaciente(@ModelAttribute("tratamientosAsociadosPacForm") PacienteTratamientosAsociados form,
      Map<String, Object> model) {
    loadTable(form.getFecha1(), form.getFecha2(), form.getTipoTratamiento(), form.getNombre(), ContextoUsuario.getIdUsuario(), model);
    return "tratamientosAsociadosPaciente";
  }
  
  private void loadTable(String f1, String f2, String pTipo, 
      String pNombre, int pUsuario, Map<String, Object> model) {
    try {
      Tabla<TablaTratamientosPaciente> resultado = TratamientoDAO.tratamientosAsociadosP(f1, f2, pTipo, pNombre, pUsuario);
      model.put("resultados", resultado);
    } catch (SQLException ex) {
      ex.printStackTrace();
    }
  }
}
