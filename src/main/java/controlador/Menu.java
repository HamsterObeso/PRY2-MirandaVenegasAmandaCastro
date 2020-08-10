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

/**
 * 
 * @author Amanda Castro, Miranda Venegas
 */
@Controller 
@RequestMapping(value = "/menu")
public class Menu {
  
    /**
     * Incio de sesión 
     * @param model objeto de tipo Tabla 
     * @return el menu del usuario que ingresó 
     */
  @RequestMapping(method = RequestMethod.GET)
  public String viewInicioSesion(Map<String, Object> model) {
    Seleccion seleccion = new Seleccion();
    model.put("usuario", ContextoUsuario.getUsuario());
    model.put("tipo", ContextoUsuario.getTipo());
    model.put("seleccion", seleccion);
    model.put("lista", FabricaOpciones.getOpciones(ContextoUsuario.getTipo()));
    return "menu";
  }

  /**
   * Valida los datos ingresados 
   * @param seleccion objeto de tipo Seleccion 
   * @param model objeto de tipo Tabla 
   * @return el ingreso a las opciones de los usuarios 
   */
  @RequestMapping(method = RequestMethod.POST)
  public String validarInicioSesion(@ModelAttribute("seleccion") Seleccion seleccion,
      Map<String, Object> model) {
    return "redirect:/" + FabricaRutas.getRuta(seleccion.getOpcion());
  }
  
}
