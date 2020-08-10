package controlador;

import formulario.FormDiagnostico;

import generico.Tabla;

import java.sql.SQLException;

import java.util.Map;

import contexto.ContextoCita;
import contexto.ContextoDiagnostico;
import contexto.ContextoUsuario;

import dao.CatalogoDiagnosticoDAO;

import dao.CitaDAO;
import dao.DiagnosticoDAO;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.CatalogoDiagnostico;

import modelo.TablaDiagnostico;

import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author Miranda Venegas, Amanda Castro 
 */
@Controller
@RequestMapping(value = "/realizarDiagnostico")
public class RealizarDiagnostico {
  
  @RequestMapping(method = RequestMethod.GET)
  public String viewRealizarDiagnostico(Map<String, Object> model) {
    FormDiagnostico form = new FormDiagnostico();
    model.put("realizarDiagnosticoF", form);
    model.put("diagnosticos", obtenerNombreCatalogoDiagnostico());
    loadTable(model);
    return "realizarDiagnostico";
  }
  
  /**
   * Cargar las opciones del diagnostico 
   * @param form objeto de tipo FormDiagnostico
   * @param model objeto de tipo Map 
   * @return 
   */
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
  
  /**
   * Permite diagnosticar a los pacientes 
   * @param model objeto de tipo Map
   * @param form objeto de tipo FormDiagnostico
   * @return 
   */
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
  /**
   * Método de atender 
   * @param model objeto de tipo Map 
   * @param form objeto de tipo FormDiagnostico
   * @return el diagnostico de la cita 
   */
  private String atender(Map<String, Object> model, FormDiagnostico form) {
    try {
      CitaDAO.atenderCita(ContextoCita.getIdCita(), ContextoUsuario.getIdUsuario());
      return "redirect:/menu";
    } catch(SQLException e){
      model.put("mensaje", "Ha ocurrido un error al atender la cita.");
      return "redirect:/realizarDiagnostico";
    }
  }
  /**
   * Tratar los diagnosticos 
   * @param model objeto de tipo Map 
   * @param form objeto de tipo FormDiagnostico
   * @return el tratamiento realizado 
   */
  private String tratar(Map<String, Object> model, FormDiagnostico form) {
    ContextoDiagnostico.setDiagnostico(form.getIdDiagnostico());
    return "redirect:/realizarTratamiento";
  }
  /**
   * Cargar los datos de los diagnosticos 
   * @param model objeto de tipo Map 
   */
  private void loadTable(Map<String, Object> model) {
    try {     
      Tabla<TablaDiagnostico> resultados = DiagnosticoDAO.obtenerDiagnosticos(ContextoCita.getIdCita());
      model.put("resultados", resultados);     
    } catch (SQLException ex) {
      ex.printStackTrace();
    }
  }
  
  /**
   * Obtener nombre de los catalogos diagnosticos 
   * @return el nombre
   */
  private ArrayList<String> obtenerNombreCatalogoDiagnostico() {
    try {
      Tabla<CatalogoDiagnostico> resultado = CatalogoDiagnosticoDAO.obtenerDiagnosticos();
      ArrayList<CatalogoDiagnostico> elementos = resultado.obtenerElementos();
      ArrayList<String> diagnosticos = new ArrayList<>();
      for(CatalogoDiagnostico elemento: elementos) {
        diagnosticos.add(elemento.getNombre());
      }
      return diagnosticos;
    } catch (Exception ex) {
      Logger.getLogger(RealizarDiagnostico.class.getName()).log(Level.SEVERE, null, ex);
    }
    return null;
  }
  
}
