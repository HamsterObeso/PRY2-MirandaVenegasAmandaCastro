package controlador;

import dao.HospitalizacionDAO;

import formulario.SecretarioHospitalizacionesRegistradas;

import java.sql.SQLException;

import java.util.Map;

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
    return "hospitalizacionesRegistradasS";
  }

  @RequestMapping(method = RequestMethod.POST)
  public String filtroHospitalizaciones(@ModelAttribute("hospitalizacionesRegistradasSForm") SecretarioHospitalizacionesRegistradas form,
      Map<String, Object> model) {
    try {
      HospitalizacionDAO.hospitalizacionesRegistradas(form.getFechaIni1(),form.getFechaFin1(), form.getFechaIni2(), form.getFechaFin2(), form.getEspecialidad(),form.getEstado(), form.getNombrePaciente());
      model.put("form", "form");
    } catch (SQLException e) {
      model.put("error", "error");
      e.printStackTrace();
    }
    return "hospitalizacionesRegistradasS";
  }

}
