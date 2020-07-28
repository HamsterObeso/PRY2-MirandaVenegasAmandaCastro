/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import dao.secretarioDAO;
import java.sql.SQLException;
import java.util.Map;
import modelo.Cita;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author Masiel Castro Mora
 */
@Controller
@RequestMapping(value = "/aisgnarCita")
public class asignarCitaControlador {
    
   public void asignarCita(int idCita,int idFuncionario){
       try{
           secretarioDAO.asignarCitaPaciente(idCita, idCita);
       } catch(SQLException e){
           e.printStackTrace();
       }
   }
}
    
    
  