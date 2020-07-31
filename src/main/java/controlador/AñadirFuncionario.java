package controlador;

import dao.FuncionarioDAO;

import java.sql.SQLException;
import java.util.Map;

import modelo.Funcionario;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author Muro
 */

@Controller
@RequestMapping(value = "/agregarFuncionario")
public class AñadirFuncionario {
  @RequestMapping(method = RequestMethod.GET)
  public String viewAnadirFuncionario(Map<String, Object> model) {
    Funcionario funcionario = new Funcionario();
    model.put("funcionarioForm", funcionario);
    return "anadirFuncionario";
  }

  @RequestMapping(method = RequestMethod.POST)  
  public String anadirFuncionario(@ModelAttribute("funcionarioForm") Funcionario funcionario,
      Map<String, Object> model) {
    try {
      FuncionarioDAO.anadirFuncionario(funcionario.getIdentificacion(), funcionario.getNombre(),
        funcionario.getTipoFuncionario(), funcionario.getArea(), funcionario.getUsuario(),
        funcionario.getContrasena());
      model.put("funcionario", "funcionario");
    } catch(SQLException e){
      model.put("error", "error");
      e.printStackTrace();
    }
    return "anadirFuncionario";
  }
}
