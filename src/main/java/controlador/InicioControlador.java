package controlador;

import java.util.Map;

import modelo.Seleccion;

import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 
 * @author Amanda Castro, Miranda Venegas 
 */

@Controller 
public class InicioControlador {
  
  @RequestMapping(method = RequestMethod.GET)
  public String viewHome(Map<String, Object> model) {
    Seleccion seleccion = new Seleccion();
    model.put("inicioF", seleccion);
    return "inicio";    
  }
  
  /**
   * Se desplegan las opciones de la pantalla principal 
   * @param seleccion
   * @param model
   * @return 
   */
  @RequestMapping(value = "/inicio", method = RequestMethod.POST)
  public String opcionesEspecialidad(@ModelAttribute("inicioF") Seleccion seleccion,
      Map<String, Object> model) {
    switch(seleccion.getOpcion()) {
      case "Iniciar Sesion":
          return "redirect:/inicioSesion";
      case "Registrar Paciente":
          return "redirect:/anadirPaciente";
      default:
          return "redirect:/agregarFuncionario";
    }
  }
}
