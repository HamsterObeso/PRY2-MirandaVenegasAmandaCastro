package controlador;

import fabrica.FabricaRutas;
import formulario.FormGestionDiagnostico;
import java.util.Map;
import modelo.Seleccion;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author pierr
 */

@Controller 
@RequestMapping(value = "/gestionDiagnostico")
public class GestionDiagnostico {
  
  @RequestMapping(method = RequestMethod.GET)
  public String viewInicioSesion(Map<String, Object> model) {
    FormGestionDiagnostico form = new FormGestionDiagnostico();
    model.put("diagnostico", form);
    return "gestionDiagnostico";
  }
  
  @RequestMapping(method = RequestMethod.POST)
  public String validarInicioSesion(@ModelAttribute("diagnostico") FormGestionDiagnostico form,
      Map<String, Object> model) {
    System.out.println(form.getOpcion());
    return "redirect:/" + "gestionDiagnostico";
  }
  
}
