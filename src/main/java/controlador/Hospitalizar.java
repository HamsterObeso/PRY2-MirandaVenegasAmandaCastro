package controlador;

import contexto.ContextoUsuario;

import dao.HospitalizacionDAO;
import dao.PacienteDAO;

import generico.Tabla;

import java.sql.SQLException;

import java.util.Map;

import modelo.TablaPacientesAtendidos;
import modelo.Hospitalizacion;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author Mranda Venegas, Amanda Castro 
 */

@Controller
@RequestMapping(value = "/hospitalizar")
public class Hospitalizar {
  @RequestMapping(method = RequestMethod.GET)
  public String viewHospitalizacion(Map<String, Object> model) {
    Hospitalizacion form = new Hospitalizacion();
    model.put("hospitalizarF", form);
    loadTable(model);
    return "hospitalizar";
  }
  
  /**
   * Se llama a la funcion añadir hospitalizacion 
   * @param form objeto de tipo Hospitalizacion
   * @param model objeto de tipo Map
   * @return la hospitalizacion de los pacientes 
   */
  @RequestMapping(method = RequestMethod.POST)  
  public String hospitalizacion (@ModelAttribute("hospitalizarF") Hospitalizacion form,
      Map<String, Object> model) {
    try {
      HospitalizacionDAO.anadirHospitalizacion(form.getNombre(), form.getIdentificacion(), form.getCentro(), form.getEspecialidad(), form.getDiagnostico(), form.getFecha(), ContextoUsuario.getIdUsuario());
    } catch(SQLException e){
      
    }
    return "redirect:/hospitalizar";
  }
  
  /**
   * Cargar los datos de paciente atendidos
   * @param model objeto de tipo Map 
   */
  private void loadTable(Map<String, Object> model) {
    try {
      Tabla<TablaPacientesAtendidos> resultado = PacienteDAO.obtenerPacientesAtentidos();
      model.put("resultados", resultado);
    } catch (SQLException ex) {
      ex.printStackTrace();
    }
  }
}
