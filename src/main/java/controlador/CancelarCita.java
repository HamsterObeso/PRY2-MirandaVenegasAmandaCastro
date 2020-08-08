package controlador;

import com.twilio.Twilio;

import com.twilio.rest.api.v2010.account.Message;

import com.twilio.type.PhoneNumber;

import contexto.ContextoUsuario;

import dao.CitaDAO;
import dao.PacienteDAO;

import generico.Tabla;

import java.sql.SQLException;

import java.util.Map;

import modelo.TablaCita;
import modelo.Cita;

import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import conexion.Email;


/**
 *
 * @author Muro
 */
@Controller
@RequestMapping(value = "/cancelarCita")
public class CancelarCita {

  public static final String ACCOUNT_SID = "ACb0102705c4599e19c6c61a51d9a4f3e6";
  public static final String AUTH_TOKEN = "b996568aa4e138ddcc7e189a254aa30d";

  @RequestMapping(method = RequestMethod.GET)
  public String viewCancelarCitaP(Map<String, Object> model) {
    Cita cita = new Cita();
    model.put("cancelarCitaPacForm", cita);
    loadTable(model);
    return "cancelarCita";
  }

  private void loadTable(Map<String, Object> model) {
    try {
      Tabla<TablaCita> resultado = CitaDAO.obtenerCitasCancelarPaciente(ContextoUsuario.getIdUsuario());
      model.put("resultados", resultado);
    } catch (SQLException ex) {
      ex.printStackTrace();
    }
  }

  @RequestMapping(method = RequestMethod.POST)
  public String cancelarCitaP(@ModelAttribute("cancelarCitaPacForm") Cita cita,
          Map<String, Object> model) {
    try {
      if (ContextoUsuario.getTipo().equals("Paciente")) {
        CitaDAO.cancelarCitaPaciente(cita.getIdCita(), ContextoUsuario.getIdUsuario());
      } else {
        CitaDAO.cancelarCitaFuncionario(cita.getIdCita(), ContextoUsuario.getIdUsuario());
      }
      model.put("cita", "cita");
      Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
      Message message = Message.creator(new PhoneNumber(PacienteDAO.telefonoPaciente(ContextoUsuario.getIdUsuario())),
              new PhoneNumber("+17206369419"), "Estimado paciente su cita fue cancelada").create();
      String correo = PacienteDAO.obtenerCorreo(ContextoUsuario.getIdUsuario());
      mandarCorreo(correo);
    } catch (SQLException e) {
      model.put("error", "error");
      e.printStackTrace();
    }
    return "cancelarCita";
  }
  
  /**
  * Se crea el objeto email deacuerdo a la información requerida
  * @param correo
  */
     
  public void mandarCorreo (String correo){
    Email email = new Email();

    email.addRecipient(correo);
    email.setSubject("Informe de cancelación de cita.");
    email.addBody("Estimado paciente, se le informa por este medio que su cita ha sido "
      + "cancelada.",false);

    if(email.sendEmail()){
        System.out.println("Correo enviado con éxito.");
    }else{
        System.out.println("Error al enviar el correo.");
    }
  }
}
