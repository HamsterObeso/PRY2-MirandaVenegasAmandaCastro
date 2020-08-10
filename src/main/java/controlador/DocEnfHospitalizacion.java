package controlador;

import dao.HospitalizacionDAO;

import formulario.DocEnfDetalleHospitalizacion;

import generico.Tabla;

import java.sql.SQLException;

import java.util.Map;

import modelo.TablaDetalleHospitalizacion;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author Miranda Venegas, Amanda Castro 
 * Método que permite conocer los detalles de las hospitalizaciones 
 */

@Controller
@RequestMapping(value = "/detalleHospitalizacion")
public class DocEnfHospitalizacion {
  @RequestMapping(method = RequestMethod.GET)
  public String viewFiltroDetalleHospitalizacion(Map<String, Object> model) {
    DocEnfDetalleHospitalizacion form = new DocEnfDetalleHospitalizacion();
    model.put("detalleHospitalizacionForm", form);
    loadTable("", model);
    return "detalleHospitalizacion";
  }
  
/**
 *Permite traer los detalles de las hospitalizaciones desde el dao
 * @param form objeto de tipo DocEnfDetalleHospitalizacion
 * @param model objeto de tipo Map
 * @return detalle de las hospitalizaciones 
 */  
  @RequestMapping(method = RequestMethod.POST)  
  public String filtroDetalleHospitalizacion(@ModelAttribute("detalleHospitalizacionForm") DocEnfDetalleHospitalizacion form,
      Map<String, Object> model) {
    loadTable(form.getNombrePaciente(), model);
    return "detalleHospitalizacion";
  }
  
  /**
   * Carga los datos de las hospitalizaciones 
   * @param nombrePaciente busqueda por nombre del paciente 
   * @param model objeto de tipo Tabla 
   */
  private void loadTable(String nombrePaciente, Map<String, Object> model) {
    try {
      Tabla<TablaDetalleHospitalizacion> resultado = HospitalizacionDAO.detalleHospitalizacion(nombrePaciente);
      model.put("resultados", resultado);
    } catch (SQLException ex) {
      ex.printStackTrace();
    }
  }
}
