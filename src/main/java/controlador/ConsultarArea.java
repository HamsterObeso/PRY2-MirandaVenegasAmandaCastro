/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import dao.areasTrabajoDAO;
import java.sql.SQLException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Masiel Castro Mora
 */

@Controller
@RequestMapping(value = "/GestionAreas")
public class ConsultarArea {
    
    private void ConsultarArea(String nombre){
        try{
            areasTrabajoDAO.consultarArea(nombre);
        } catch(SQLException e){
            
        }
    }
    
    
}
