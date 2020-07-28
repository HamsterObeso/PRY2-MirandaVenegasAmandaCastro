/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

/**
 *
 * @author Masiel Castro Mora
 */

import dao.secretarioDAO;
import java.sql.SQLException;
import java.util.Map;
import modelo.Cuenta;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller 
@RequestMapping(value = "/secretario")
public class secretarioControlador {
    
     
    @RequestMapping(method = RequestMethod.GET)
    public String viewSecretario(Map<String, Object> model){
        Cuenta cuenta = new Cuenta();
        model.put("userForm", cuenta);
        return "secretario";
    }
    
    public void cancelarCita( int idCita, int idFuncionario){
        try{
            secretarioDAO.cancelarCita(idCita, idFuncionario);
        } catch(SQLException e){
            e.printStackTrace();
        }
    }
    
    public void asignarCita (int idCita, int idFuncionario){
        try{
            secretarioDAO.asignarCitaPaciente(idCita, idFuncionario);  
        } catch(SQLException e){
            e.printStackTrace();
        }
    }
    
    public void citasRegistradas(String fecha1, String fecha2, String estado, String especialidad, String nombrePaciente){
        try{
            secretarioDAO.citasRegistradas(fecha1, fecha2, estado, especialidad, nombrePaciente);
        } catch(SQLException e){
            e.printStackTrace();
        }
    }
    
    
}
