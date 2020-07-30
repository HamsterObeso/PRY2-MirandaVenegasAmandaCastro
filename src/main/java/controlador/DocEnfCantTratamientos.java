/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import formulario.DocEnfCantidadTratamientos;
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
@RequestMapping(value = "/cantidadTratamientos")
public class DocEnfCantTratamientos {
  
  @RequestMapping(method = RequestMethod.GET)
  public String viewFiltroCantidadTratamientos(Map<String, Object> model) {
    DocEnfCantidadTratamientos form = new DocEnfCantidadTratamientos();
    model.put("cantidadTratamientosForm", form);
    return "cantidadTratamientos";
  }
    
  @RequestMapping(method = RequestMethod.POST)  
  public String filtroCantidadDiagnosticos(@ModelAttribute("cantidadTratamientosForm") DocEnfCantidadTratamientos form,
      Map<String, Object> model) {
    //filtroCantTratamientos(form.getTratamiento(), form.getEspecialidad(), form.getIdentificacion())
    System.out.println(form.getTratamiento());
    System.out.println(form.getEspecialidad());
    System.out.println(form.getIdentificacion());
    return "cantidadTratamientos";
  }
}
