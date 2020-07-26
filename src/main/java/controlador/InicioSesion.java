package controlador;

import conexion.ConexionSQL;
import java.util.Map;
import modelo.Cuenta;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author Miranda Venegas
 */
@Controller 
@RequestMapping(value = "/inicioSesion")
public class InicioSesion {
    
    @RequestMapping(method = RequestMethod.GET)
    public String viewInicioSesion(Map<String, Object> model){
      Cuenta cuenta = new Cuenta();
      model.put("userForm", cuenta);
      return "inicioSesion";
    }
    
    @RequestMapping(method = RequestMethod.POST)
    public String validarInicioSesion(@ModelAttribute("userForm") Cuenta cuenta,
        Map<String, Object> model) {
      //TODO logica inicio de sesion
      ConexionSQL.getConnection();
      return "home";
    }
    
}
