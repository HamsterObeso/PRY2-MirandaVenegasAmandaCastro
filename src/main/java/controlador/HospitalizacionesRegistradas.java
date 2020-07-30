/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import formulario.SecretarioCitasRegistradas;
import java.util.Map;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author Masiel Castro Mora
 */
@Controller
@RequestMapping(value = "/hospitalizacionesRegistradas")
public class HospitalizacionesRegistradas {

    @RequestMapping(method = RequestMethod.GET)
    public String viewFiltroHospitalizacionesRegistradas(Map<String, Object> model) {
        SecretarioCitasRegistradas form = new SecretarioCitasRegistradas();
        model.put("hospitalizacionesRegistradasSForm", form);
        return "hospitalizacionesRegistradasS";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String filtroCitasSistema(@ModelAttribute("hospitalizacionesRegistradasSForm") SecretarioCitasRegistradas form,
            Map<String, Object> model) {
        //filtroCitasSistema(form.getFecha1(), form.getFecha2(), form.getEspecialidad(), form.getEstado(), form.getNombrePaciente())
        System.out.println(form.getFecha1());
        System.out.println(form.getFecha2());
        System.out.println(form.getEspecialidad());
        System.out.println(form.getEstado());
        System.out.println(form.getNombrePaciente());

        return "citasRegistradas";
    }

}
