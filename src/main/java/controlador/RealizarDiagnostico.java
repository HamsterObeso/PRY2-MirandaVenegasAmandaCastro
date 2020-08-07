package controlador;

import formulario.FormDiagnostico;

import generico.Tabla;

import java.sql.SQLException;

import java.util.Map;

import contexto.ContextoCita;
import contexto.ContextoDiagnostico;

import dao.CitaDAO;
import dao.DiagnosticoDAO;

import modelo.TablaDiagnostico;

import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author Muro
 */

@Controller
@RequestMapping(value = "/realizarDiagnostico")
public class RealizarDiagnostico {
  
  @RequestMapping(method = RequestMethod.GET)
  public String viewRealizarDiagnostico(Map<String, Object> model) {
    FormDiagnostico form = new FormDiagnostico();
    model.put("realizarDiagnosticoF", form);
    loadTable(model);
    return "gestionDiagnostico";
  }
  
  @RequestMapping(method = RequestMethod.POST)
  public String diagnostico(@ModelAttribute("realizarDiagnosticoF") FormDiagnostico form,
      Map<String, Object> model) {
    switch(form.getOpcion()) {
      case "Diagnosticar":
          return diagnosticar(model, form);
      case "Atender":
          return atender(model, form);
      default:
          return tratar(model, form);
    }
  }
  
  private String diagnosticar(Map<String, Object> model, FormDiagnostico form) {
    String nombre = form.getNombreDiagnostico();
    String nivel = form.getNivel();
    String observaciones = form.getObservaciones();
    if(nombre == null || nivel == null || observaciones == null) {
      model.put("mensaje", "Debe ingresar un nombre para el diagnostico");
    }
    else {
      try {
        DiagnosticoDAO.anadirDiagnostico(nombre, nivel, observaciones, ContextoCita.getIdCita());
        model.put("mensaje", "Se agrego el nuevo diagnostico");
      } catch(SQLException x){
        model.put("mensaje", "Falló al agregarse el diagnostico.");
      }
    }
    loadTable(model);
    return "redirect:/realizarDiagnostico";
  }
  
  private String atender(Map<String, Object> model, FormDiagnostico form) {
    try {
      CitaDAO.atenderCita(ContextoCita.getIdCita());
      return "redirect:/menu";
    } catch(SQLException e){
      model.put("mensaje", "Ha ocurrido un error al atender la cita.");
      return "redirect:/realizarDiagnostico";
    }
  }
  
  private String tratar(Map<String, Object> model, FormDiagnostico form) {
    ContextoDiagnostico.setDiagnostico(form.getIdDiagnostico());
    return "redirect:/realizarTratamiento";
  }
  
  private void loadTable(Map<String, Object> model) {
    try {     
      Tabla<TablaDiagnostico> resultados = DiagnosticoDAO.obtenerDiagnosticos(ContextoCita.getIdCita());
      model.put("resultados", resultados);     
    } catch (SQLException ex) {
      ex.printStackTrace();
    }
  }
}
