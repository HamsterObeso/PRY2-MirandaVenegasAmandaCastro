package controlador;

import contexto.ContextoUsuario;

import dao.CitaDAO;

import generico.Tabla;

import java.sql.SQLException;

import java.util.Map;

import modelo.Cita;
import modelo.TablaCita;

import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author Amanda Castro, Miranda Venegas
 * Clase que permite asignar una cita 
 */
@Controller
@RequestMapping(value = "/asignarCita")
public class AsignarCita {
    
  @RequestMapping(method = RequestMethod.GET)
  public String viewSolicitarCita(Map<String, Object> model) {
    Cita cita = new Cita();
    model.put("patientForm", cita);
    loadTable(model);
    return "asignarCita";
  }

  /**
   * 
   * @param cita objeto de tipo Cita
   * @param model objeto de tipo Map
   * @return 
   */
  @RequestMapping(method = RequestMethod.POST)  
  public String asignarCita(@ModelAttribute("patientForm") Cita cita,
    Map<String, Object> model) {
  try {
    CitaDAO.asignarCita(cita.getIdCita(),ContextoUsuario.getIdUsuario());
    model.put("cita", "cita");
  } catch(SQLException e){
    model.put("error", "error");
    e.printStackTrace();
  }
  return "asignarCita";
  }
  
  /**
   * Carga la tabla de citas asignadas
   * @param model objeto de tipo Map 
   */
  private void loadTable(Map<String, Object> model) {
    try {
      Tabla<TablaCita> resultado = CitaDAO.obtenerCitasAsignar();
      model.put("resultados", resultado);
    } catch (SQLException ex) {
      ex.printStackTrace();
    }
  }

}
