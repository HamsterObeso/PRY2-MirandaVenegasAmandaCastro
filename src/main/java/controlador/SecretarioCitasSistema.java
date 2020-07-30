package controlador;

import dao.CitaDAO;
import formulario.SecretarioCitasRegistradas;
import java.sql.SQLException;
import java.util.Map;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author Muro
 */
@Controller
@RequestMapping(value = "/citasSistema")
public class SecretarioCitasSistema {

    @RequestMapping(method = RequestMethod.GET)
    public String viewFiltroCitasSistema(Map<String, Object> model) {
        SecretarioCitasRegistradas form = new SecretarioCitasRegistradas();
        model.put("citasRegistradasSecreForm", form);
        return "citasRegistradas";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String filtroCitasSistema(@ModelAttribute("citasRegistradasSecreForm") SecretarioCitasRegistradas form,
            Map<String, Object> model) {
        try {
            CitaDAO.citasSistema(form.getFecha1(), form.getFecha2(), form.getEstado(), form.getEspecialidad(), form.getNombrePaciente());
            model.put("form", "form");
        } catch (SQLException e) {
            model.put("error", "error");
            e.printStackTrace();
        }

        return "citasRegistradas";
    }
}
