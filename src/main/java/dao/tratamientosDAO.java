/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import conexion.conexionSQL;
import static dao.diagnosticoDAO.result; //FALTA
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import modelo.diagnosticos; //FALTA
import modelo.tratamientos; //FALTA

/**
 *
 * @author Masiel Castro Mora
 */

public class tratamientosDAO {
    public static tratamientos tratamiento;
    public static ResultSet resul;
    
    public void añadirNombreTratamientos(String nombre, int IDNombreDiag) throws SQLException{
        CallableStatement entrada = conexionSQL.getConnection().prepareCall("{call anadirnombresT(?,?)}"); 
        entrada.setString(1, nombre);
        entrada.setInt(2,IDNombreDiag);
        entrada.execute();
    }
    
     public void consultarNombre(String nombre) throws SQLException{
        CallableStatement entrada = conexionSQL.getConnection().prepareCall("{call consultarNombreT(?)}"); 
        entrada.setString(1, nombre);
        entrada.execute();
    }
    
    public void modificarNombre(int IDCategoria, String nombre) throws SQLException{
        CallableStatement entrada = conexionSQL.getConnection().prepareCall("{call modificarNombresT(?,?)}"); 
        entrada.setInt(1, IDCategoria);
        entrada.setString(2, nombre);
        entrada.execute();
    }
    
    public void eliminarNombre(String nombre) throws SQLException{
        CallableStatement entrada = conexionSQL.getConnection().prepareCall("{call eliminarNombreT(?)}"); 
        entrada.setString(1, nombre);
        entrada.execute();
    }
    public void obtenerDatos() throws SQLException{
        CallableStatement salida = conexionSQL.getConnection().prepareCall("{call mostrarNombreT}");
        result=salida.executeQuery();
        try{
            while(result.next()){
                tratamientos tratamiento = new tratamientos(result.getInt(1),result.getInt(2),result.getInt(3), result.getString(4), result.getInt(5));
            }
        }catch (SQLException e){
        }
    }
}
