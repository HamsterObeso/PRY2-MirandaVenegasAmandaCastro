package controlador;

import dao.AreasTrabajoDAO;

import formulario.FormGestionEspecialidad;

import java.sql.SQLException;

import java.util.ArrayList;
import java.util.Map;

import modelo.TablaEspecialidad;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author Muro
 */

@Controller 
@RequestMapping(value = "/gestionEspecialidad")
public class GestionEspecialidad {
  
  @RequestMapping(method = RequestMethod.GET)
  public String viewGestionEspecialidad(Map<String, Object> model) {
    FormGestionEspecialidad form = new FormGestionEspecialidad();
    model.put("especialidad", form);
    loadTable(model);
    return "especialidades";
  }
  
  @RequestMapping(method = RequestMethod.POST)
  public String opcionesEspecialidad(@ModelAttribute("especialidad") FormGestionEspecialidad form,
      Map<String, Object> model) {
    switch(form.getOpcion()) {
      case "Crear":
          return crear(model, form);
      case "Actualizar":
          return actualizar(model, form);
      default:
          return eliminar(model, form);
    }
  }
  
  private String crear(Map<String, Object> model, FormGestionEspecialidad form) {
    String nombre = form.getNombre();
    if(nombre == null) {
      model.put("mensaje", "Debe ingresar un nombre para el área.");
    }
    else {
      AreasTrabajoDAO.crearArea(nombre);
      model.put("mensaje", "Se agregó la nueva área de trabajo.");
    }
    loadTable(model);
    return "redirect:/gestionEspecialidad";
  }
  
  private String actualizar(Map<String, Object> model, FormGestionEspecialidad form) {
    String nombre = form.getNombre();
    int id = form.getId();
    if(nombre == null || id == -1) {
      model.put("mensaje", "Debe completar la informacion");
    }
    else {
      AreasTrabajoDAO.actualizarArea(id, nombre);
      model.put("mensaje", "Se actualizo el área");
    }
    loadTable(model);
    return "redirect:/gestionEspecialidad";
  }
  
  private String eliminar(Map<String, Object> model, FormGestionEspecialidad form) {
    int id = form.getId();
    if(id == -1) {
      model.put("mensaje", "Debe ingresar un id valido");
    }
    else {
      AreasTrabajoDAO.eliminarArea(id);
      model.put("mensaje", "Se elimino el área");
    }
    loadTable(model);
    return "redirect:/gestionEspecialidad";
  }
  
  private void loadTable(Map<String, Object> model) {
    try {     
      ArrayList<TablaEspecialidad> resultados = AreasTrabajoDAO.obtenerAreas();
      model.put("resultados", resultados);     
    } catch (SQLException ex) {
      ex.printStackTrace();
    }
  }
  
}
