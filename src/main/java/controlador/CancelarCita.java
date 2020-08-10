package controlador;

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
import mensaje.Mensaje;


/**
 *
 * @author Miranda Venegas, Amanda Castro
 * Clase que permite cancelar cita 
 */
@Controller
@RequestMapping(value = "/cancelarCita")
public class CancelarCita {

  @RequestMapping(method = RequestMethod.GET)
  public String viewCancelarCitaP(Map<String, Object> model) {
    Cita cita = new Cita();
    model.put("cancelarCitaPacForm", cita);
    loadTable(model);
    return "cancelarCita";
  }

  /**
   * Carga el método obtenerCitasCancelarPaciente
   * @param model objeto de tipo Tabla 
   */
  private void loadTable(Map<String, Object> model) {
    try {
      if(ContextoUsuario.getTipo().equals("Paciente")){
        Tabla<TablaCita> resultado = CitaDAO.obtenerCitasCancelarPaciente(ContextoUsuario.getIdUsuario());
        model.put("resultados", resultado);
      } else {
        Tabla<TablaCita> resultado = CitaDAO.obtenerCitasCancelar();
        model.put("resultados", resultado);
      }
    } catch (SQLException ex) {
      ex.printStackTrace();
    }
  }

  /**
   * Método que permite cancelar citas 
   * @param cita objeto de tipo Cita
   * @param model objeto de tipo Map
   * @return Se calcela la cita 
   */
  @RequestMapping(method = RequestMethod.POST)
  public String cancelarCitaP(@ModelAttribute("cancelarCitaPacForm") Cita cita,
          Map<String, Object> model) {
    int resultado = 0;
    int num = 0;
    String correo = null;
    String telefono = null;
    try {
      if (ContextoUsuario.getTipo().equals("Paciente")) {
        resultado = CitaDAO.cancelarCitaPaciente(cita.getIdCita(), ContextoUsuario.getIdUsuario());
        correo = PacienteDAO.obtenerCorreo(ContextoUsuario.getIdUsuario());
        telefono = PacienteDAO.telefonoPaciente(ContextoUsuario.getIdUsuario());
        num = resultado;
      } else {
        resultado = CitaDAO.cancelarCitaFuncionario(cita.getIdCita(), ContextoUsuario.getIdUsuario());
        correo = CitaDAO.obtenerCorreoFuncionario(cita.getIdCita());
        telefono = CitaDAO.telefonoPacienteFuncionario(cita.getIdCita());
        num = resultado;
      }
      model.put("cita", "cita");
      if (num == 1){
        Mensaje.enviarMensaje(telefono, "La cita se ha cancelado");
        mandarCorreo(correo);
      }
    } catch (SQLException e) {
      model.put("error", "error");
      e.printStackTrace();
    }
    loadTable(model);
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
