package controlador;

import contexto.ContextoCita;
import dao.CitaDAO;

import formulario.FormAtenderCita;

import generico.Tabla;

import java.sql.SQLException;

import java.util.Map;

import modelo.TablaCita;

import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author Amanda Castro, Miranda Venegas 
 * Clase que permite atender una cita 
 */

@Controller
@RequestMapping(value = "/atenderCita")
public class AtenderCita {
  @RequestMapping(method = RequestMethod.GET)
  public String viewAtenderCita(Map<String, Object> model) {
    FormAtenderCita form = new FormAtenderCita();
    model.put("atenderCitaForm", form);
    loadTable(model);
    return "atenderCita";
  }
   
  /**
   * 
   * @param form objeto tipo atenderCita form
   * @param model objeto de tipo Tabla 
   * @return la cita atendida 
   */
  @RequestMapping(method = RequestMethod.POST)  
  public String atenderCita(@ModelAttribute("atenderCitaForm") FormAtenderCita form,
      Map<String, Object> model) {
    ContextoCita.guardarCita(form.getIdCita());
    return "redirect:/realizarDiagnostico";
  }
  
  /**
   * Carga tabla de citas Atendidas 
   * @param model objeto de tipo Tabla 
   */
  private void loadTable(Map<String, Object> model) {
    try {
      Tabla<TablaCita> resultado = CitaDAO.obtenerCitasAtender();
      model.put("resultados", resultado);
    } catch (SQLException ex) {
      ex.printStackTrace();
    }
  }
}
