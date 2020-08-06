package controlador;

import dao.TipoCentroDAO;

import java.sql.SQLException;

import java.util.ArrayList;
import java.util.Map;

import modelo.TipoCentroAtencion;
import modelo.TablaTipoCentro;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author Muro
 */
@Controller 
@RequestMapping(value = "/agregarTipoCentro")
public class AgregarTipoCentro {
  
  @RequestMapping(method = RequestMethod.GET)
  public String viewTipoCentro(Map<String, Object> model) {
    TipoCentroAtencion tipoCentro = new TipoCentroAtencion();
    model.put("agregarTipoCentroForm", tipoCentro);
    loadTable(model);
    return "tipoCentro";
  }
  
  @RequestMapping(method = RequestMethod.POST)  
  public String tipoCentro(@ModelAttribute("agregarTipoCentroForm") TipoCentroAtencion tipoCentro,
      Map<String, Object> model) {
    String nombre = tipoCentro.getNombre();
    if(nombre == null) {
      model.put("mensaje", "Debe ingresar un nombre para el tipo de centro");
    }
    else {
      TipoCentroDAO.crearTipoCentro(nombre);
      model.put("mensaje", "Se agrego el nuevo diagnostico");
    }
    loadTable(model);
    return "redirect:/agregarTipoCentro";
  }
  
  private void loadTable(Map<String, Object> model) {
    try {     
      ArrayList<TablaTipoCentro> resultados = TipoCentroDAO.obtenerTipoCentros();
      model.put("resultados", resultados);     
    } catch (SQLException ex) {
      ex.printStackTrace();
    }
  }
}
