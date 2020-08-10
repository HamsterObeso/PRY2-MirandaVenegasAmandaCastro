package controlador;

import conexion.Email;
import contexto.ContextoUsuario;

import dao.CitaDAO;
import dao.PacienteDAO;

import java.sql.SQLException;

import java.util.Map;
import mensaje.Mensaje;

import modelo.Cita;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author Muro
 */
@Controller
@RequestMapping(value = "/solicitarCita")
public class SolicitarCita {
  @RequestMapping(method = RequestMethod.GET)
  public String viewSolicitarCita(Map<String, Object> model) {
    Cita cita = new Cita();
    model.put("patientForm", cita);
    return "solicitarCita";
  }

  @RequestMapping(method = RequestMethod.POST)  
  public String solicitudCita(@ModelAttribute("patientForm") Cita cita,
      Map<String, Object> model) {
    String correo = null;
    String telefono = null;
    try {
      CitaDAO.anadirCita(cita.getEspecialidad(), cita.getFecha(), cita.getHora(), cita.getObservacion(), ContextoUsuario.getIdUsuario());
      correo = PacienteDAO.obtenerCorreo(ContextoUsuario.getIdUsuario());
      telefono = PacienteDAO.telefonoPaciente(ContextoUsuario.getIdUsuario());
      Mensaje.enviarMensaje(telefono, "Su cita ha sido solicitada existosamente.");
      mandarCorreo(correo);
      model.put("cita", "cita");
    } catch(SQLException e){
      model.put("error", "error");
      e.printStackTrace();
    }
    return "solicitarCita";
  }
  
  /**
  * Se crea el objeto email deacuerdo a la información requerida
  * @param correo
  */

  public void mandarCorreo (String correo){
    Email email = new Email();

    email.addRecipient(correo);
    email.setSubject("Informe de solicitud de cita.");
    email.addBody("Estimado paciente, se le informa por este medio que su cita ha sido "
      + "solicitada exitosamente.",false);

    if(email.sendEmail()){
        System.out.println("Correo enviado con éxito.");
    }else{
        System.out.println("Error al enviar el correo.");
    }
  }
}
