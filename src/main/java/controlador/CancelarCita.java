package controlador;

import static com.google.common.collect.ArrayListMultimap.create;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import contexto.ContextoUsuario;
import dao.CatalogoDiagnosticoDAO;
import dao.CitaDAO;
import static java.lang.Integer.parseInt;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;
import modelo.TablaCancelarCita;
import modelo.Cita;
import modelo.Paciente;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


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
        return "redirect:/cancelarCitaPaciente";
    }

    private void loadTable(Map<String, Object> model) {
        try {
            ArrayList<TablaCancelarCita> resultados = CitaDAO.obtenerCitasCancelarPaciente(ContextoUsuario.getIdUsuario());
            model.put("resultados", resultados);
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
            String num;
            Message message = Message.creator(new PhoneNumber(CitaDAO.telefonoPaciente(ContextoUsuario.getIdUsuario())),
                    new PhoneNumber("+17206369419"), "Estimado paciente su cita fue cancelada").create();
        } catch (SQLException e) {
            model.put("error", "error");
            e.printStackTrace();
        }
        return "cancelarCitaPaciente";
    }

}
