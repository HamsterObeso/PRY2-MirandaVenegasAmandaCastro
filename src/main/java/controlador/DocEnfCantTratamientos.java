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
 * @author Miranda Venegas, Amanda Castro 
 * Clase que permite conocer la cantidad de tratamientos 
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
    
  /**
   * Método que permite el filtro de cantidad de tratamientos 
   * @param form objeto de tipo DocEnfCantidadTratamientos
   * @param model objeto de tipo Tabla 
   * @return la cantidad de tratamietos 
   */
  @RequestMapping(method = RequestMethod.POST)  
  public String filtroCantidadDiagnosticos(@ModelAttribute("cantidadTratamientosForm") DocEnfCantidadTratamientos form,
      Map<String, Object> model) {
    loadTable(form.getTratamiento(), form.getEspecialidad(), form.getIdentificacion(), model);
    return "cantidadTratamientos";
  }
  
  /**
   * Carga los filtros encontrados 
   * @param pTipo tipo de tratamiento
   * @param pEspecialidad especialidad del tratamiento 
   * @param pPaciente nombre paciente 
   * @param model objeto de tipo Tabla 
   */
  private void loadTable(String pTipo, String pEspecialidad, String pPaciente,
    Map<String, Object> model) {
    try {
      Tabla<TablaCantidadTratamientos> resultado = TratamientoDAO.cantidadTratamientos(pTipo, pEspecialidad, pPaciente);
      model.put("resultados", resultado);
    } catch (SQLException ex) {
      ex.printStackTrace();
    }
  }
}
