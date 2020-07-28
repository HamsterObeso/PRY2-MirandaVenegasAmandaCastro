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
@RequestMapping(value = "/hospitalizacionesRegistradas")
public class hospitalizacionesRegistradas {
    
    public void hospitalizacionesRegistradas(String fechaIni1, String fechaIni2, String fechaFinal1, String fechaFinal2, String estado, String especialidad, String nombrePaciente){
        try{
            secretarioDAO.hospitalizacionesRegistradas(fechaIni1, fechaIni2, fechaFinal1, fechaFinal2, estado, especialidad, nombrePaciente);
        } catch (SQLException e){
            e.printStackTrace();
        }
    }
}