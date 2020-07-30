package controlador;

import formulario.DocEnfDetalleHospitalizacion;
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
    //filtroDetalleHospitalizacion(form.getNombrePaciente())
    System.out.println(form.getNombrePaciente());
    return "detalleHospitalizacion";
  }
}
