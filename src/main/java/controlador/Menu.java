package controlador;

import contexto.ContextoUsuario;
import fabrica.FabricaOpciones;
import fabrica.FabricaRutas;
import java.util.Map;
import modelo.Seleccion;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller 
@RequestMapping(value = "/menu")
public class Menu {
  
  @RequestMapping(method = RequestMethod.GET)
  public String viewInicioSesion(Map<String, Object> model) {
    Seleccion seleccion = new Seleccion();
    model.put("usuario", ContextoUsuario.getUsuario());
    model.put("tipo", ContextoUsuario.getTipo());
    model.put("seleccion", seleccion);
    model.put("lista", FabricaOpciones.getOpciones(ContextoUsuario.getTipo()));
    return "menu";
  }

  @RequestMapping(method = RequestMethod.POST)
  public String validarInicioSesion(@ModelAttribute("seleccion") Seleccion seleccion,
      Map<String, Object> model) {
    return "redirect:/" + FabricaRutas.getRuta(seleccion.getOpcion());
  }
  
}
