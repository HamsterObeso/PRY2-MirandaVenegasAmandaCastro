package controlador;

import dao.HospitalizacionDAO;

import formulario.SecretarioHospitalizacionesRegistradas;

import generico.Tabla;

import java.sql.SQLException;

import java.util.Map;

import modelo.TablaHospitalizaciones;

import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author Masiel Castro Mora
 */
@Controller
@RequestMapping(value = "/hospitalizacionesRegistradas")
public class HospitalizacionesRegistradas {

  @RequestMapping(method = RequestMethod.GET)
  public String viewFiltroHospitalizacionesRegistradas(Map<String, Object> model) {
    SecretarioHospitalizacionesRegistradas form = new SecretarioHospitalizacionesRegistradas();
    model.put("hospitalizacionesRegistradasSForm", form);
    loadTable("", "", "", "", "", "", "", model);
    return "hospitalizacionesRegistradas";
  }

  @RequestMapping(method = RequestMethod.POST)
  public String filtroHospitalizaciones(@ModelAttribute("hospitalizacionesRegistradasSForm") 
    SecretarioHospitalizacionesRegistradas form,
      Map<String, Object> model) {
    loadTable(form.getFechaIni1(), form.getFechaFin1(), form.getFechaIni2(), form.getFechaFin2(), 
      form.getEstado(), form.getEspecialidad(), form.getNombrePaciente(), model);
    return "hospitalizacionesRegistradas";
  }

  private void loadTable(String fechaIni1, String fechaFin1, String fechaIni2, String fechaFin2, 
      String estado,String especialidad, String nombrePaciente, Map<String, Object> model) {
    try {
      Tabla<TablaHospitalizaciones> resultado = HospitalizacionDAO.hospitalizacionesRegistradas
  (fechaIni1, fechaFin1, fechaIni2, fechaFin2, estado, especialidad, nombrePaciente);
      model.put("resultados", resultado);
    } catch (SQLException ex) {
      ex.printStackTrace();
    }
  }
}
