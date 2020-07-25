package controlador;

import dao.PacienteDAO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller public class InicioControlador {
    
    @RequestMapping(value="/home", method = RequestMethod.GET)
    public String viewHome(){
        PacienteDAO pacientito = new PacienteDAO();
        System.out.println("holi");
        return "home";
        
    }
    
    
    
}
