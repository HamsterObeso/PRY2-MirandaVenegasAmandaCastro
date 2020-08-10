package controlador;

import dao.CatalogoDiagnosticoDAO;

import formulario.FormGestionDiagnostico;
import generico.Tabla;

import java.sql.SQLException;
import java.util.Map;

import modelo.CatalogoDiagnostico;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author Miranda Venegas, Amanda Castro
 * Clase que permite gestionar los diagnosticos
 */
@Controller 
@RequestMapping(value = "/gestionDiagnostico")
public class GestionDiagnostico {
  
  @RequestMapping(method = RequestMethod.GET)
  public String viewInicioSesion(Map<String, Object> model) {
    FormGestionDiagnostico form = new FormGestionDiagnostico();
    model.put("diagnostico", form);
    loadTable(model);
    return "gestionDiagnostico";
  }
  /**
   *Permite cargar los datos desde el form FormGestionDiagnostico
   * @param form objeto de tipo FormGestionDiagnostico
   * @param model objeto de tipo Map 
   * @return gestionar los diagnosticos 
   */
  @RequestMapping(method = RequestMethod.POST)
  public String validarInicioSesion(@ModelAttribute("diagnostico") FormGestionDiagnostico form,
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
   * Crear un nuevo diagnostico 
   * @param model objeto de tipo Map
   * @param form objeto de tipo FormGestionDiagnostico
   * @return  se crea el diagnsotico 
   */
  private String crear(Map<String, Object> model, FormGestionDiagnostico form) {
    String nombre = form.getNombre();
    if(nombre == null) {
      model.put("mensaje", "Debe ingresar un nombre para el diagnostico");
    }
    else {
      CatalogoDiagnosticoDAO.crearDiagnostico(nombre);
      model.put("mensaje", "Se agrego el nuevo diagnostico");
    }
    loadTable(model);
    return "redirect:/gestionDiagnostico";
  }
  
  /**
   * Permite actualizar la información del diagnostico 
   * @param model objeto de tipo Tabla 
   * @param form objeto de tipo FormGestionDiagnostico
   * @return los datos actualizados 
   */
  private String actualizar(Map<String, Object> model, FormGestionDiagnostico form) {
    String nombre = form.getNombre();
    int id = form.getId();
    if(nombre == null || id == -1) {
      model.put("mensaje", "Debe completar la informacion");
    }
    else {
      CatalogoDiagnosticoDAO.actualizarDiagnostico(id, nombre);
      model.put("mensaje", "Se actualizo el diagnostico");
    }
    loadTable(model);
    return "redirect:/gestionDiagnostico";
  }
  
  /**
   * Elimina un diagnostico 
   * @param model objeto de tipo Map
   * @param form objeto de tipo FormGestionDiagnostico
   * @return eliminación del diagnostico 
   */
  private String eliminar(Map<String, Object> model, FormGestionDiagnostico form) {
    int id = form.getId();
    if(id == -1) {
      model.put("mensaje", "Debe ingresar un id valido");
    }
    else {
      CatalogoDiagnosticoDAO.eliminarDiagnostico(id);
      model.put("mensaje", "Se elimino el diagnostico");
    }
    loadTable(model);
    return "redirect:/gestionDiagnostico";
  }
  
  /**
   * Carga los datos de los diagnosticos 
   * @param model objeto del tipo Map 
   */
  private void loadTable(Map<String, Object> model) {
    try {     
      Tabla<CatalogoDiagnostico> resultados = CatalogoDiagnosticoDAO.obtenerDiagnosticos();
      model.put("resultados", resultados);     
    } catch (SQLException ex) {
      ex.printStackTrace();
    }
  }
  
}
