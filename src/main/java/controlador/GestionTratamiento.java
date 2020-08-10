package controlador;

import dao.CatalogoTratamientoDAO;

import formulario.FormGestionTratamiento;

import java.sql.SQLException;

import java.util.ArrayList;
import java.util.Map;

import modelo.CatalogoTratamiento;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author Miranda Venegas Amanda Castro 
 * Permite la gestión de tratamientos 
 */
@Controller 
@RequestMapping(value = "/gestionTratamiento")
public class GestionTratamiento {
  
  @RequestMapping(method = RequestMethod.GET)
  public String viewGestionTratamiento(Map<String, Object> model) {
    FormGestionTratamiento form = new FormGestionTratamiento();
    model.put("tratamiento", form);
    loadTable(model);
    return "gestionTratamiento";
  }
  
  /**
   * Permite cargas las opciones de los tratamientos 
   * @param form objeto de tipo FormGestionTratamiento
   * @param model objeto de tipo Tabla 
   * @return 
   */
  @RequestMapping(method = RequestMethod.POST)
  public String opcionesTratamiento(@ModelAttribute("tratamiento") FormGestionTratamiento form,
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
   * Crear un tratamiento
   * @param model objeto de tipo Tabla 
   * @param form objeto de tipo FormGestionTratamiento
   * @return se crea un tratamiento.
   */
  private String crear(Map<String, Object> model, FormGestionTratamiento form) {
    String nombre = form.getNombre();
    String diagnostico = form.getDiagnostico();
    if(nombre == null || diagnostico == null) {
      model.put("mensaje", "Debe ingresar un nombre y diagnostico para el tratamiento.");
    }
    else {
      CatalogoTratamientoDAO.crearTratamiento(nombre, diagnostico);
      model.put("mensaje", "Se agrego el nuevo tratamiento");
    }
    loadTable(model);
    return "redirect:/gestionTratamiento";
  }
  /**
   * Actualizar un tratamiento
   * @param model objeto de tipo Tabla 
   * @param form objeto de tipo FormGestionTratamiento
   * @return se actualiza un tratamiento.
   */
  private String actualizar(Map<String, Object> model, FormGestionTratamiento form) {
    String nombre = form.getNombre();
    String diagnostico = form.getDiagnostico();
    int id = form.getId();
    if(nombre == null || id == -1) {
      model.put("mensaje", "Debe completar la informacion");
    }
    else {
      CatalogoTratamientoDAO.actualizarTratamiento(id, nombre, diagnostico);
      model.put("mensaje", "Se actualizo el tratamiento");
    }
    loadTable(model);
    return "redirect:/gestionTratamiento";
  }
  /**
   * Eliminar un tratamiento
   * @param model objeto de tipo Tabla 
   * @param form objeto de tipo FormGestionTratamiento
   * @return se elimina un tratamiento.
   */
  private String eliminar(Map<String, Object> model, FormGestionTratamiento form) {
    int id = form.getId();
    if(id == -1) {
      model.put("mensaje", "Debe ingresar un id valido");
    }
    else {
      CatalogoTratamientoDAO.eliminarTratamiento(id);
      model.put("mensaje", "Se elimino el diagnostico");
    }
    loadTable(model);
    return "redirect:/gestionTratamiento";
  }
  /**
   * Se cargan los datos de los tratamientos 
   * @param model objeto tipo Tabla 
   */
  private void loadTable(Map<String, Object> model) {
    try {     
      ArrayList<CatalogoTratamiento> resultados = CatalogoTratamientoDAO.obtenerTratamientos();
      model.put("resultados", resultados);     
    } catch (SQLException ex) {
      ex.printStackTrace();
    }
  }
  
}
