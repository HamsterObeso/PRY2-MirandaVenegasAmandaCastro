package controlador;

import contexto.ContextoUsuario;
import dao.HospitalizacionDAO;

import dao.SeguimientoDAO;
import generico.Tabla;

import java.sql.SQLException;

import java.util.Map;

import modelo.Seguimiento;
import modelo.TablaHospitalizaciones;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author Muro
 */
@Controller
@RequestMapping(value = "/realizarSeguimiento")
public class RealizarSeguimiento {
  @RequestMapping(method = RequestMethod.GET)
  public String viewRealizarSeguimiento(Map<String, Object> model) {
    Seguimiento seguimiento = new Seguimiento();
    model.put("realizarSeguimientoForm", seguimiento);
    loadTable(model);
    return "seguimiento";
  }

  @RequestMapping(method = RequestMethod.POST)  
  public String seguimiento(@ModelAttribute("realizarSeguimientoForm") Seguimiento seguimiento,
      Map<String, Object> model) {
    try {
      SeguimientoDAO.anadirSeguimiento(seguimiento.getIdHospitalizacion(),  ContextoUsuario.getIdUsuario(), seguimiento.getObservacion(), seguimiento.getTratamientoAsociado());
      model.put("tratamiento", "tratamiento");
    } catch(SQLException e){
      model.put("error", "error");
      e.printStackTrace();
    }
    return "seguimiento";
  }
  
  private void loadTable(Map<String, Object> model) {
    try {
      Tabla<TablaHospitalizaciones> resultado = HospitalizacionDAO.obtenerHospitalizaciones();
      model.put("resultados", resultado);
    } catch (SQLException ex) {
      ex.printStackTrace();
    }
  }
}
