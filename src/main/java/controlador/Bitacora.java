package controlador;

import dao.BitacoraDAO;
import formulario.FormGestionDiagnostico;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;
import modelo.TablaBitácora;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author Muro
 */

@Controller 
@RequestMapping(value = "/cargarBitacora")
public class Bitacora {
  
  @RequestMapping(method = RequestMethod.GET)
  public String viewInicioSesion(Map<String, Object> model) {
    loadTable(model);
    return "bitacora";
  }
  
  private void loadTable(Map<String, Object> model) {
    try {     
      ArrayList<TablaBitácora> resultados = BitacoraDAO.obtenerBitacora();
      model.put("resultados", resultados);
    } catch (SQLException ex) {
      ex.printStackTrace();
    }
  }
}
