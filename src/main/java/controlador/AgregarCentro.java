package controlador;

import dao.CentroDAO;

import java.sql.SQLException;

import java.util.ArrayList;
import java.util.Map;

import modelo.CentroAtencion;
import modelo.TablaCentrosAtencion;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author Amanda Castro, Miranda Venegas
 * 
 */

/**
 * Método que permite agregar centros 
 */
@Controller 
@RequestMapping(value = "/agregarCentro")
public class AgregarCentro {
  
  @RequestMapping(method = RequestMethod.GET)
  public String viewCentro(Map<String, Object> model) {
    CentroAtencion centro = new CentroAtencion();
    model.put("agregarCentroForm", centro);
    loadTable(model);
    return "centroAtencion";
  }
  
  @RequestMapping(method = RequestMethod.POST)  
  public String agregarCentro(@ModelAttribute("agregarCentroForm") CentroAtencion centro,
      Map<String, Object> model) {
    String nombre = centro.getNombre();
    String lugar = centro.getLugar();
    int capacidad = centro.getCapacidad();
    String tipoCentro = centro.getTipo();
    if(nombre == null) {
      model.put("mensaje", "Debe ingresar un nombre para el centro");
    }
    else {
      CentroDAO.crearCentro(nombre, lugar, capacidad, tipoCentro);
      model.put("mensaje", "Se agrego el nuevo centro");
    }
    loadTable(model);
    return "redirect:/agregarCentro";
  }
  
  /**
   * Carga la tabla de centroAtencion 
   * @param model objeto de tipo Map 
   */
  private void loadTable(Map<String, Object> model) {
    try {     
      ArrayList<TablaCentrosAtencion> resultados = CentroDAO.obtenerCentros();
      model.put("resultados", resultados);     
    } catch (SQLException ex) {
      ex.printStackTrace();
    }
  }
}
