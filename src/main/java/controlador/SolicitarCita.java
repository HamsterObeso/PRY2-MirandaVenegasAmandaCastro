package controlador;

import conexion.ConexionSQL;
import contexto.ContextoUsuario;
import dao.CitaDAO;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;
import modelo.Cita;
import modelo.Cuenta;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author Muro
 */
public class SolicitarCita {
    
  @RequestMapping(method = RequestMethod.GET)
    public String viewSolicitarCita(Map<String, Object> model) {
      Cita cita = new Cita();
      model.put("patientForm", cita);
      return "solicitarCita";
    }
    
    private void solicitarCita(String pEspecialidad, String pFechaHora, String pObservacion, int idPaciente) {
      try{
        CitaDAO.anadirCita(pEspecialidad, pFechaHora, pObservacion, idPaciente);
      } catch(SQLException e){
        e.printStackTrace();
      }
    }
    
}
