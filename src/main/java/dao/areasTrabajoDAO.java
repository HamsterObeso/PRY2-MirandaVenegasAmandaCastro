/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

/**
 *
 * @author Masiel Castro Mora
 */

import conexion.conexionSQL;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import modelo.areasTrabajo;

/**
 *
 * @author Amanda Castro, Miranda Venegas 
 */
public class areasTrabajoDAO {
    public static areasTrabajo areas;
    public static ResultSet result;
    
    //Gestión de areas
    
    public void agregarArea(areasTrabajo areas) throws SQLException{
        CallableStatement entrada = conexionSQL.getConnection().prepareCall("{call anadirAreas(?)}");
        entrada.setString(1,areas.getNombre());
        entrada.execute();
    }
    
    public void consultarArea(String pNombre) throws SQLException{
        CallableStatement entrada = conexionSQL.getConnection().prepareCall("{call consultarArea(?)}");
        System.out.println(entrada);
        entrada.setString(1,pNombre);
        entrada.execute(); 
    }
    
    public void borrarArea(String pNombre) throws SQLException{
        CallableStatement entrada = conexionSQL.getConnection().prepareCall("{call borrarArea(?)}");
        entrada.setString(1,pNombre);
        entrada.execute(); 
    }
    
    public static void actualizarCategoria(String idArea,String nombre) throws SQLException{
        CallableStatement entrada = conexionSQL.getConnection().prepareCall("{call actualizarArea(?,?)}");
        entrada.setString(1,idArea);
        entrada.setString(1,nombre);
        entrada.execute(); 
     
    } 
    
    
}
