package conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import java.sql.Statement;

/**
 *
 * @author Masiel Castro Mora
 */
public class ConexionSQL {
  
   private static Connection contact = null;   
  
  /**Metodo para conectarse a la base de datos de sql
   * @return  la coneccion con sql
   */
  public static Connection getConnection(){
    try {
      Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
      String dbURL = "jdbc:sqlserver://DESKTOP-EGNA5V0\\BASEDATOS:1433;databaseName=proyecto2;user=sa;password=sa";
      contact = DriverManager.getConnection(dbURL);
    } catch (SQLException | ClassNotFoundException ex) {
        ex.printStackTrace();
    }
    return contact;
  }
    
  /**
  * Metodo que consultar en la base de datos 
  * @param  query recibe la consulta que se va a realizar en bd
  * @return null en caso de no lograr hacer la consulta
  */
  public static ResultSet Consulta(String query){
    Connection con = getConnection();
    Statement declare;
    try{
      declare=con.createStatement();
      ResultSet answer = declare.executeQuery(query);
      return answer;
    }catch(SQLException e){
      JOptionPane.showMessageDialog(null,"No se realizo la consulta"+ e.getMessage(),
         "Error de conexion",JOptionPane.ERROR_MESSAGE);            
    }
    return null;
  }
    
}
