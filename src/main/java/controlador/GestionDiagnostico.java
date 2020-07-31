package controlador;

import dao.CatalogoDiagnosticoDAO;
import formulario.FormGestionDiagnostico;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;
import modelo.CatalogoDiagnostico;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author Miranda Venegas
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
  
  private void loadTable(Map<String, Object> model) {
    try {     
      ArrayList<CatalogoDiagnostico> resultados = CatalogoDiagnosticoDAO.obtenerDiagnosticos();
      model.put("resultados", resultados);     
    } catch (SQLException ex) {
      ex.printStackTrace();
    }
  }
  
}
