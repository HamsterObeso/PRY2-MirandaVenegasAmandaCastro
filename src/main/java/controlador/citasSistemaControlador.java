/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import dao.secretarioDAO;
import java.sql.SQLException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Masiel Castro Mora
 */
@Controller
@RequestMapping(value = "/citasRegistradas")
public class citasSistemaControlador {
    
    public void citasSistema(String fecha1, String fecha2, String estado, String especialidad, String nombrePaciente){
        try{
            secretarioDAO.citasRegistradas(fecha1, fecha2, estado, especialidad, nombrePaciente);
        } catch(SQLException e){
            e.printStackTrace();
        }
    }
    
}
