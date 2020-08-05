package controlador;

import dao.TratamientoDAO;

import formulario.DocEnfCantidadTratamientos;

import generico.Tabla;

import java.sql.SQLException;

import java.util.Map;

import modelo.TablaCantidadTratamientos;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author Muro
 */

@Controller
@RequestMapping(value = "/cantidadTratamientos")
public class DocEnfCantTratamientos {
  
  @RequestMapping(method = RequestMethod.GET)
  public String viewFiltroCantidadTratamientos(Map<String, Object> model) {
    DocEnfCantidadTratamientos form = new DocEnfCantidadTratamientos();
    model.put("cantidadTratamientosForm", form);
    loadTable("", "", "", model);
    return "cantidadTratamientos";
  }
    
  @RequestMapping(method = RequestMethod.POST)  
  public String filtroCantidadDiagnosticos(@ModelAttribute("cantidadTratamientosForm") DocEnfCantidadTratamientos form,
      Map<String, Object> model) {
    loadTable(form.getTratamiento(), form.getEspecialidad(), form.getIdentificacion(), model);
    return "cantidadTratamientos";
  }
  
  private void loadTable(String pTipo, String pEspecialidad, String pEstado,
    Map<String, Object> model) {
    try {
      Tabla<TablaCantidadTratamientos> resultado = TratamientoDAO.cantidadTratamientos(pTipo, pEstado, pEspecialidad);
      model.put("resultados", resultado);
    } catch (SQLException ex) {
      ex.printStackTrace();
    }
  }
}
