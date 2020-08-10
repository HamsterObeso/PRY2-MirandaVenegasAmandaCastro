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
 * @author Miranda Venegas, Amanda Castro 
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
  /**
   * Carga las opciones de gestion de la especialidad
   * @param form objeto de tipo FormGestionEspecialidad
   * @param model objeto de tipo Tabla 
   * @return la opción deseada
   */
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
  
  /**
   * Crear una especialidad
   * @param model  un objeto tipo Tabla
   * @param form objeto de tipo FormGestionEspecialidad
   * @return se crea la especialidad
   */
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
  
  /**
   * Actualizar los datos de la especialidad
   * @param model  un objeto tipo Tabla
   * @param form objeto de tipo FormGestionEspecialidad
   * @return actualiza la especialidad
   */
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
  
  /**
   * Eliminar una especialidad
   * @param model  un objeto tipo Tabla
   * @param form objeto de tipo FormGestionEspecialidad
   * @return se elimina la especialidad
   */
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
  
  /**
   * Se cargan los datos de las areas de trabajo
   * @param model objeto de tipo Map 
   */
  
  private void loadTable(Map<String, Object> model) {
    try {     
      ArrayList<TablaEspecialidad> resultados = AreasTrabajoDAO.obtenerAreas();
      model.put("resultados", resultados);     
    } catch (SQLException ex) {
      ex.printStackTrace();
    }
  }
  
}
