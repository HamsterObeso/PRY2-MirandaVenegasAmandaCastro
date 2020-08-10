package controlador;

import conector.ConectorTSE;
import dao.PacienteDAO;
import modelo.Paciente;
import java.util.Map;
import modelo.Telefono;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author Amanda Castro, Miranda Venegas 
 * Clase que permite agregar pacientes 
 */

@Controller
public class AñadirPaciente {
  
  @RequestMapping(value = "/anadirPaciente", method = RequestMethod.GET)
  public String viewAnadirPaciente(Map<String, Object> model) {
    Paciente pac = new Paciente();
    Telefono tel = new Telefono();
    model.put("paciente", pac);
    model.put("telefono", tel);
    return "anadirPaciente";
  }
  /**
   * 
   * @param form objeto de tipo Paciente 
   * @param model objeto de tipo Map
   * @return añade al paciente 
   */
  @RequestMapping(value="/anadirPaciente", method = RequestMethod.POST)
  public String anadirPaciente(@ModelAttribute("paciente") Paciente form,
      Map<String, Object> model) {
    String identificacion = form.getIdentificacion();
    String fechaNacimiento = form.getFechaNacimiento();
    String tipoSangre = form.getTipoSangre();
    String nacionalidad = form.getNacionalidad();
    String correo = form.getCorreo();
    String usuario = form.getUsuario();
    String contraseña = form.getContraseña();
    if(identificacion == null || identificacion.length()<9) {
      model.put("mensaje", "Revise su identificacion.");
    } else {
      String[] resultado = ConectorTSE.obtenerInformacion(identificacion);
      if (resultado[0].equals("404")){
        model.put("mensaje", "Revise el número de identificacion");
      } else {
        PacienteDAO.AgregarPaciente(identificacion, resultado[1], fechaNacimiento, tipoSangre, nacionalidad,
        resultado[2], resultado[3], correo, usuario, contraseña);
        model.put("mensaje", "Se agregó el nuevo paciente.");
      }
    }
    return "redirect:/anadirPaciente";
  }

  /**
   * Método que permite añasor telefonos 
   * @param tel objeto de tipo Telefono 
   * @param model objeto de tipo Map 
   * @return añade el telefono 
   */
  @RequestMapping(value="/anadirTelefono", method = RequestMethod.POST)
  public String anadirTelefono(@ModelAttribute("telefono") Telefono tel,
      Map<String, Object> model) {
    String identificacion = tel.getIdentificacion();
    String telefono = tel.getTelefono();
    if(identificacion == null || telefono == null) {
      model.put("mensaje", "Debe ingresar su identificacion y teléfono.");
    }
    else {
      PacienteDAO.AgregarTelefono(identificacion, telefono);
      model.put("mensaje", "Se agregó el nuevo telefono.");
    }
    return "redirect:/anadirPaciente";
  }
}
