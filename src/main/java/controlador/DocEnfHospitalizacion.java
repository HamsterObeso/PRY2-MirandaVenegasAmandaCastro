package controlador;

import contexto.ContextoUsuario;
import dao.CitaDAO;
import dao.HospitalizacionDAO;
import formulario.DocEnfDetalleHospitalizacion;
import java.sql.SQLException;
import java.util.Map;
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
    return "detalleHospitalizacion";
  }
    
  @RequestMapping(method = RequestMethod.POST)  
  public String filtroDetalleHospitalizacion(@ModelAttribute("detalleHospitalizacionForm") DocEnfDetalleHospitalizacion form,
      Map<String, Object> model) {
    try {
      HospitalizacionDAO.detalleHospitalizacion(form.getNombrePaciente());
      model.put("form", "form");
    } catch(SQLException e){
      model.put("error", "error");
      e.printStackTrace();
    }
    return "detalleHospitalizacion";
  }
}
