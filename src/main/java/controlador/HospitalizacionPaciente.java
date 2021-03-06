package controlador;

import contexto.ContextoUsuario;

import dao.HospitalizacionDAO;

import generico.Tabla;

import java.sql.SQLException;

import java.util.Map;

import modelo.TablaHospitalizacionesPaciente;

import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author Miranda Venegas, Amanda Castro 
 */
@Controller 
@RequestMapping(value = "/hospitalizacionPaciente")
public class HospitalizacionPaciente {
  
  @RequestMapping(method = RequestMethod.GET)
  public String viewInicioSesion(Map<String, Object> model) {
    loadTable(model);
    return "hospitalizacionesPaciente";
  }
  
  /**
   * Carga los datos de las hospitalizaciones 
   * @param model objeto de tipo Tabla 
   */
  private void loadTable(Map<String, Object> model) {
    try {     
      Tabla<TablaHospitalizacionesPaciente> resultados = 
        HospitalizacionDAO.obtenerHospitalizacionesPaciente(ContextoUsuario.getIdUsuario());
      model.put("resultados", resultados);
    } catch (SQLException ex) {
      ex.printStackTrace();
    }
  }
}
