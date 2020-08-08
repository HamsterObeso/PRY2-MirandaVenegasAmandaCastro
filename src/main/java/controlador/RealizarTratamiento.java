package controlador;

import contexto.ContextoDiagnostico;

import dao.TratamientoDAO;
import dao.CatalogoTratamientoDAO;

import generico.Tabla;

import java.sql.SQLException;

import java.util.Map;

import modelo.Tratamiento;
import modelo.CatalogoTratamiento;

import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author Muro
 */

@Controller
@RequestMapping(value = "/realizarTratamiento")
public class RealizarTratamiento {
  
  @RequestMapping(method = RequestMethod.GET)
  public String viewRealizarTratamiento(Map<String, Object> model) {
    Tratamiento form = new Tratamiento();
    model.put("realizarTratamientoF", form);
    loadTable(model);
    return "realizarTratamiento";
  }
  
  @RequestMapping(method = RequestMethod.POST)  
  public String tratamiento(@ModelAttribute("realizarTratamientoF") 
    Tratamiento form, Map<String, Object> model) {
    try {
      TratamientoDAO.anadirTratamiento(form.getNombreTratamiento(), form.getDosis(), form.getTipo(), ContextoDiagnostico.getIdDiagnostico());
      model.put("mensaje", "Se ha agregado el tratamiento.");
    } catch(SQLException e){
      model.put("mensaje", "Ha ocurrido un error al agregar el tratamiento.");
    }
    loadTable(model);
    return "redirect:/realizarTratamiento";
  }
  
  private void loadTable(Map<String, Object> model) {
    try {     
      Tabla<CatalogoTratamiento> resultados = CatalogoTratamientoDAO.obtenerTratamientosID(ContextoDiagnostico.getIdDiagnostico());
      model.put("resultados", resultados);     
    } catch (SQLException ex) {
      ex.printStackTrace();
    }
  }
}
