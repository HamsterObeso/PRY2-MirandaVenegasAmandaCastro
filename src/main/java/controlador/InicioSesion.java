package controlador;

import conexion.ConexionSQL;
import contexto.ContextoUsuario;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
    public String viewInicioSesion(Map<String, Object> model) {
      Cuenta cuenta = new Cuenta();
      model.put("userForm", cuenta);
      model.put("opacity", 0);
      return "inicioSesion";
    }
    
    @RequestMapping(method = RequestMethod.POST)
    public String validarInicioSesion(@ModelAttribute("userForm") Cuenta cuenta,
        Map<String, Object> model) {
      if(!cuenta.iniciarSesion()) {
        model.put("opacity", 1);
        return "inicioSesion";
      } else {
        model.put("usuario", ContextoUsuario.getUsuario());
        model.put("tipo", ContextoUsuario.getTipo());
        return "menu";
      }
    }
    
}
