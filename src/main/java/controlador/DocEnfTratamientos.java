package controlador;

import dao.TratamientoDAO;

import formulario.DocEnfTratamientosAsociadosPaciente;

import generico.Tabla;

import java.sql.SQLException;

import java.util.Map;

import modelo.TablaTratamientosDE;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author Miranda Venegas, Amanda Castro 
 * Método que permite conocer los tratamientos 
 */

@Controller
@RequestMapping(value = "/tratamientosDocEnf")
public class DocEnfTratamientos {
  @RequestMapping(method = RequestMethod.GET)
  public String viewFiltroCantidadCitas(Map<String, Object> model) {
    DocEnfTratamientosAsociadosPaciente form = new DocEnfTratamientosAsociadosPaciente();
    model.put("tratamientosDocEnfForm", form);
    loadTable("", "", "", "", "", model);
    return "tratamientosDocEnf";
  }
   /**
    * Se cargaran los datos de dao 
    * @param form objeto de tipo DocEnfTratamientosAsociadosPaciente
    * @param model objeto de tipo Tabla 
    * @return 
    */ 
  @RequestMapping(method = RequestMethod.POST)  
  public String filtroTratamientosDE(@ModelAttribute("tratamientosDocEnfForm") DocEnfTratamientosAsociadosPaciente form,
      Map<String, Object> model) {
    loadTable(form.getFecha1(), form.getFecha2(), form.getTipoTratamiento(), form.getNombreTratamiento(), form.getIdentificacion(), model);
    return "tratamientosDocEnf";
  }
  
  /**
   * Se cargaran los datos 
   * @param f1 fecha inicial 
   * @param f2 fecha final
   * @param pTipo tipo de tratamiento 
   * @param pNombre nombre del tratamiento 
   * @param pIdentificacion identificacion del paciente 
   * @param model objeto de tipo Map 
   */
  private void loadTable(String f1, String f2, String pTipo, 
      String pNombre, String pIdentificacion, Map<String, Object> model) {
    try {
      Tabla<TablaTratamientosDE> resultado = TratamientoDAO.tratamientosAsociadosDE(f1, f2, pTipo, pNombre, pIdentificacion);
      model.put("resultados", resultado);
    } catch (SQLException ex) {
      ex.printStackTrace();
    }
  }
}
