package controlador;

import dao.CitaDAO;

import formulario.DocEnfCantidadCitas;
import generico.Tabla;

import java.sql.SQLException;

import java.util.Map;
import modelo.TablaCantidadCitas;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author Miranda Venegas, Amanda Castro 
 * Clase que permite saber la cantidad de citas 
 */

@Controller
@RequestMapping(value = "/cantidadCitas")
public class DocEnfCantCitas {
  
  @RequestMapping(method = RequestMethod.GET)
  public String viewFiltroCantidadCitas(Map<String, Object> model) {
    DocEnfCantidadCitas form = new DocEnfCantidadCitas();
    model.put("cantidadCitasForm", form);
    loadTable("", "", "", "", model);
    return "cantidadCitas";
  }
   
  /**
   * 
   * @param form objeto tipo form cantidadCitas
   * @param model objeto de tipo Tabla 
   * @return 
   */
  @RequestMapping(method = RequestMethod.POST)  
  public String filtroCantidadCitas(@ModelAttribute("cantidadCitasForm") DocEnfCantidadCitas form,
      Map<String, Object> model) {
    loadTable(form.getFecha1(), form.getFecha2(), form.getEspecialidad(), form.getEstado(), model);
    return "cantidadCitas";
  }
  
  /**
   * Carga la tabla de cantidad de citas 
   * @param f1 primer fecha 
   * @param f2 segunda fecha 
   * @param pEstado estado cita
   * @param pEspecialidad especialidad cita
   * @param model objeto de tipo Tabla 
   */
  private void loadTable(String f1, String f2, String pEstado, 
      String pEspecialidad, Map<String, Object> model) {
    try {
      Tabla<TablaCantidadCitas> resultado = CitaDAO.cantidadCitas(f1, f2, pEstado, pEspecialidad);
      model.put("resultados", resultado);
    } catch (SQLException ex) {
      ex.printStackTrace();
    }
  }
  
}
