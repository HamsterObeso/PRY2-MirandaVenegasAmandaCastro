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
 * @author Muro
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
    
  @RequestMapping(method = RequestMethod.POST)  
  public String filtroDetalleHospitalizacion(@ModelAttribute("detalleHospitalizacionForm") DocEnfDetalleHospitalizacion form,
      Map<String, Object> model) {
    loadTable(form.getNombrePaciente(), model);
    return "detalleHospitalizacion";
  }
  
  private void loadTable(String nombrePaciente, Map<String, Object> model) {
    try {
      Tabla<TablaDetalleHospitalizacion> resultado = HospitalizacionDAO.detalleHospitalizacion(nombrePaciente);
      model.put("resultados", resultado);
    } catch (SQLException ex) {
      ex.printStackTrace();
    }
  }
}
