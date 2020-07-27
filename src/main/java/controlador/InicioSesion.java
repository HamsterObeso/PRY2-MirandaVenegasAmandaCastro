package controlador;

import conexion.ConexionSQL;
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
      String tipoUsuario = iniciarSesion(cuenta.getUsuario(), cuenta.getPassword());
      if(tipoUsuario == null) {
        model.put("opacity", 1);
        return "inicioSesion";
      } else {
        return "menu";
      }
    }
    
    private String iniciarSesion(String usuario, String password) {
      try(CallableStatement cstmt = ConexionSQL.getConnection()
          .prepareCall("{call iniciarSesion(?, ?)}");) {
        cstmt.setString(1, usuario);
        cstmt.setString(2, password);       
        try(ResultSet result = cstmt.executeQuery()) {
          String tipoUsuario = null;
          while(result.next()) {         
            tipoUsuario = result.getString("TipoUsuario");
          }
          result.close();
          return tipoUsuario;
        }    
      } catch(SQLException e) {
        e.printStackTrace();       
      }
      return null;
    }
    
}
