package dao;

import java.sql.CallableStatement;
import java.sql.SQLException;

import conexion.ConexionSQL;

import generico.Tabla;

import java.sql.ResultSet;

import modelo.TablaCita;
import modelo.TablaCitasDE;
import modelo.TablaCantidadCitas;

/**
 *
 * @author Miranda, Amanda 
 */
public class CitaDAO {
  
  private static String correo;
  private static String telefono;
  
  /**
   * Atender cita 
   * @param idCita identificacion de cita 
   * @param idDiagnostico identificación de diagnostico 
   * @throws SQLException 
   */
  public static void atenderCita(int idCita , int idDiagnostico) throws SQLException {
    CallableStatement entrada = ConexionSQL.getConnection().prepareCall("{call atenderCita(?, ?)}");
    entrada.setInt(1, idCita);
    entrada.setInt(2, idDiagnostico);
    entrada.execute();
  }
  
  /**
   * Datos citas atender 
   * @return las citas atendidas 
   * @throws SQLException 
   */
  public static Tabla<TablaCita> obtenerCitasAtender() throws SQLException {
    try (CallableStatement cstmt = ConexionSQL.getConnection()
          .prepareCall("{call cargarCitasAtender()}");) {
      try (ResultSet result = cstmt.executeQuery()) {
        Tabla<TablaCita> resultados = new Tabla<>();
        while (result.next()) {
            int id = result.getInt("IDcita");
            String especialidad = result.getString("especialidad");
            String fecha = result.getString("fecha");
            String hora = result.getString("hora");
            String observacion = result.getString("observacion");
            String estado = result.getString("estado");
            TablaCita resultado = new TablaCita(id, especialidad, fecha, hora, observacion, estado);
            resultados.agregar(resultado);
          }
        result.close();
        return resultados;
      }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return null;
  }
  
  /**
   * Obtener citas canceladas por el paciente 
   * @param idUsuario
   * @return citas canceladas por el paciente 
   * @throws SQLException 
   */
  
  public static Tabla<TablaCita> obtenerCitasCancelarPaciente(int idUsuario) throws SQLException {
    try (CallableStatement cstmt = ConexionSQL.getConnection()
          .prepareCall("{call obtenerCitasCancelarPaciente(?)}");) {
      cstmt.setInt(1, idUsuario);
      try (ResultSet result = cstmt.executeQuery()) {
        Tabla<TablaCita> resultados = new Tabla<>();
        while (result.next()) {
          int id = result.getInt("IDcita");
          String especialidad = result.getString("especialidad");
          String fecha = result.getString("fecha");
          String hora = result.getString("hora");
          String observacion = result.getString("observacion");
          String estado = result.getString("estado");
          TablaCita resultado = new TablaCita(id, especialidad, fecha, hora, observacion, estado);
          resultados.agregar(resultado);
          }
        result.close();
        return resultados;
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return null;
  }
  
  /**
   * Obtener citas canceladas  
   * @return citas canceladas 
   * @throws SQLException 
   */
  
  public static Tabla<TablaCita> obtenerCitasCancelar() throws SQLException {
    try (CallableStatement cstmt = ConexionSQL.getConnection()
          .prepareCall("{call obtenerCitasCancelar()}");) {
      try (ResultSet result = cstmt.executeQuery()) {
        Tabla<TablaCita> resultados = new Tabla<>();
        while (result.next()) {
          int id = result.getInt("IDcita");
          String especialidad = result.getString("especialidad");
          String fecha = result.getString("fecha");
          String hora = result.getString("hora");
          String observacion = result.getString("observacion");
          String estado = result.getString("estado");
          TablaCita resultado = new TablaCita(id, especialidad, fecha, hora, observacion, estado);
          resultados.agregar(resultado);
          }
        result.close();
        return resultados;
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return null;
  }

  /**
   * Obtener citas asignadas
   * @return citas asignasdas 
   * @throws SQLException 
   */
  public static Tabla<TablaCita> obtenerCitasAsignar() throws SQLException {
    try (CallableStatement cstmt = ConexionSQL.getConnection()
          .prepareCall("{call cargarCitasAsignar()}");) {
      try (ResultSet result = cstmt.executeQuery()) {
        Tabla<TablaCita> resultados = new Tabla<>();
        while (result.next()) {
            int id = result.getInt("IDcita");
            String especialidad = result.getString("especialidad");
            String fecha = result.getString("fecha");
            String hora = result.getString("hora");
            String observacion = result.getString("observacion");
            String estado = result.getString("estado");
            TablaCita resultado = new TablaCita(id, especialidad, fecha, hora, observacion, estado);
            resultados.agregar(resultado);
          }
        result.close();
        return resultados;
      }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return null;
  }

  /**
   * Añade una cita 
   * @param especialidad especialidad  de la cita 
   * @param fecha fecha de la cita 
   * @param hora hora 
   * @param observacion observacion de la cita 
   * @param idUsuario identificación del usuario 
   * @throws SQLException 
   */
  public static void anadirCita(String especialidad, String fecha, String hora, String observacion,
          int idUsuario) throws SQLException {
    CallableStatement entrada = ConexionSQL.getConnection().prepareCall("{call anadirCitas(?, ?, ?, ?, ?)}");
    entrada.setString(1, especialidad);
    entrada.setString(2, fecha);
    entrada.setString(3, hora);
    entrada.setString(4, observacion);
    entrada.setInt(5, idUsuario);
    entrada.execute();
  }

  /**
   * cancelar la cita del paciente 
   * @param idCita identificación cita
   * @param idUsuario identificacion usuario
   * @return cita cancelada
   * @throws SQLException 
   */
  public static int cancelarCitaPaciente(int idCita, int idUsuario) throws SQLException {
    CallableStatement entrada = ConexionSQL.getConnection().prepareCall("{? = call cancelarCitaPaciente(?, ?)}");
    entrada.registerOutParameter(1, java.sql.Types.INTEGER);
    entrada.setInt(2, idCita);
    entrada.setInt(3, idUsuario);
    entrada.execute();
    int num = entrada.getInt(1);
    System.out.println(String.valueOf(num));
    return num;
  }

  /**
   * cancelar la cita del paciente por el funcionario 
   * @param idCita identificación cita
   * @param idUsuario identificacion usuario
   * @return cita cancelada
   * @throws SQLException 
   */
  public static int cancelarCitaFuncionario(int idCita, int idUsuario) throws SQLException {
    CallableStatement entrada = ConexionSQL.getConnection().prepareCall("{? = call cancelarCitaCentro(?, ?)}");
    entrada.registerOutParameter(1, java.sql.Types.INTEGER);
    entrada.setInt(2, idCita);
    entrada.setInt(3, idUsuario);
    entrada.execute();
    int num = entrada.getInt(1);
    System.out.println(String.valueOf(num));
    return num;
  }

  /**
   * Citas asociadas al paciente 
   * @param f1 fecha inicial 
   * @param f2 fecha final 
   * @param pEstado estado
   * @param pEspecialidad especialidad
   * @param idUsuario identificacion usuario 
   * @return citas asociadas al paciente 
   * @throws SQLException 
   */
  public static Tabla<TablaCita> citasAsociadasPaciente(String f1, String f2, String pEstado, String pEspecialidad, int idUsuario) throws SQLException {
      CallableStatement entrada = ConexionSQL.getConnection().prepareCall("{call citasAsociadasAlPaciente(?, ?, ?, ?, ?)}");
      if (f1.isEmpty() == true) {
          entrada.setNull(1, java.sql.Types.VARCHAR);
      } else {
          entrada.setString(1, f1);
      }
      if (f2.isEmpty() == true) {
          entrada.setNull(2, java.sql.Types.VARCHAR);
      } else {
          entrada.setString(2, f2);
      }
      if (pEstado.isEmpty() == true) {
          entrada.setNull(3, java.sql.Types.VARCHAR);
      } else {
          entrada.setString(3, pEstado);
      }
      if (pEspecialidad.isEmpty() == true) {
          entrada.setNull(4, java.sql.Types.VARCHAR);
      } else {
          entrada.setString(4, pEspecialidad);
      }
      entrada.setInt(5, idUsuario);
      try(ResultSet result = entrada.executeQuery()) {
        Tabla<TablaCita> tabla = new Tabla<>();
        while(result.next()) {
          int idCita = result.getInt("idCita");
          String especialidad = result.getString("especialidad");
          String fecha = result.getString("fecha");
          String hora = result.getString("hora");
          String observacion = result.getString("observacion");
          String estado = result.getString("estado");
          TablaCita resultado = new TablaCita(idCita, especialidad, fecha, hora, observacion, estado);
          tabla.agregar(resultado);
        }
        result.close();
        return tabla;
      } catch(SQLException e) {
      e.printStackTrace();
    }
    return null;
  }

  /**
   * Cantidad de citas 
   * @param f1 fecha inicial
   * @param f2 fecha final 
   * @param pEspecialidad especialidad citas 
   * @param pEstado estado citas 
   * @return cantidad de citas deacuedo a los solicitado 
   * @throws SQLException 
   */
  public static Tabla<TablaCantidadCitas> cantidadCitas(String f1, String f2, String pEspecialidad, String pEstado)
          throws SQLException {
    CallableStatement entrada = ConexionSQL.getConnection().prepareCall("{call cantidadCitas(?, ?, ?, ?)}");
    if (f1.isEmpty() == true) {
        entrada.setNull(1, java.sql.Types.VARCHAR);
    } else {
        entrada.setString(1, f1);
    }
    if (f2.isEmpty() == true) {
        entrada.setNull(2, java.sql.Types.VARCHAR);
    } else {
        entrada.setString(2, f2);
    }
    if (pEspecialidad.isEmpty() == true) {
        entrada.setNull(3, java.sql.Types.VARCHAR);
    } else {
        entrada.setString(3, pEspecialidad);
    }
    if (pEstado.isEmpty() == true) {
        entrada.setNull(4, java.sql.Types.VARCHAR);
    } else {
        entrada.setString(4, pEstado);
    }
    try(ResultSet result = entrada.executeQuery()) {
      Tabla<TablaCantidadCitas> tabla = new Tabla<>();
      int total = 0;
      while(result.next()) {
        total ++;
      }
      TablaCantidadCitas resultado = new TablaCantidadCitas(total, clamp(f1), clamp(f2), clamp(pEspecialidad), clamp(pEstado));
      tabla.agregar(resultado);
      result.close();
      return tabla;
    } catch(SQLException e) {
      e.printStackTrace();
    }
    return null;
  }
  
  public static String clamp(String valor){
    if(valor.isEmpty()){
      return "Sin indicar";
    } else {
      return valor;
    }
  }
  /**
   * Citas en sistema 
   * @param f1 fecha inicial 
   * @param f2 fecha final
   * @param pEstado estado de la cita 
   * @param pEspecialidad especialidad cita 
   * @param pNombrePaciente nombre paciente 
   * @return citas en sistema 
   * @throws SQLException 
   */
  // Funciona para ambos doctor|enfermero y secretario. Mismos parámetros.
  public static Tabla<TablaCitasDE> citasSistema(String f1, String f2, String pEstado, String pEspecialidad,
          String pNombrePaciente) throws SQLException {
    try(CallableStatement entrada = ConexionSQL.getConnection()
        .prepareCall("{call citasSistema(?, ?, ?, ?, ?)}");) {
      if (f1.isEmpty() == true) {
          entrada.setNull(1, java.sql.Types.VARCHAR);
      } else {
          entrada.setString(1, f1);
      }
      if (f2.isEmpty() == true) {
          entrada.setNull(2, java.sql.Types.VARCHAR);
      } else {
          entrada.setString(2, f2);
      }
      if (pEstado.isEmpty() == true) {
          entrada.setNull(3, java.sql.Types.VARCHAR);
      } else {
          entrada.setString(3, pEstado);
      }
      if (pEspecialidad.isEmpty() == true) {
          entrada.setNull(4, java.sql.Types.VARCHAR);
      } else {
          entrada.setString(4, pEspecialidad);
      }
      if (pNombrePaciente.isEmpty() == true) {
          entrada.setNull(5, java.sql.Types.VARCHAR);
      } else {
          entrada.setString(5, pNombrePaciente);
      }
      try(ResultSet result = entrada.executeQuery()) {
        Tabla<TablaCitasDE> tabla = new Tabla<>();
        while(result.next()) {
          int idCita = result.getInt("idCita");
          String especialidad = result.getString("especialidad");
          String fecha = result.getString("fecha");
          String hora = result.getString("hora");
          String observacion = result.getString("observacion");
          String estado = result.getString("estado");
          String nombrePaciente = result.getString("nombrePaciente");
          TablaCitasDE resultado = new TablaCitasDE(idCita, especialidad, fecha, hora, observacion, estado, nombrePaciente);
          tabla.agregar(resultado);
        }
        result.close();
        return tabla;
      }
    } catch(SQLException e) {
      e.printStackTrace();
    }
    return null;
  }
  
  /**
   * Asignar cita 
   * @param idCita identificacion cita 
   * @param idUsuario identificacion usuario 
   * @throws SQLException 
   */

  public static void asignarCita(int idCita, int idUsuario) throws SQLException {
      CallableStatement entrada = ConexionSQL.getConnection().prepareCall("{call asignarCita(?, ?)}");
      entrada.setInt(1, idCita);
      entrada.setInt(2, idUsuario);
      entrada.execute();
  }
  
  /**
   * Correo del funcionario 
   * @param idCita
   * @return correo del funcionario 
   * @throws SQLException 
   */
  public static String obtenerCorreoFuncionario(int idCita) throws SQLException{
    CallableStatement entrada = ConexionSQL.getConnection().prepareCall("{? = call obtenerCorreoFuncionario(?)}");
    entrada.registerOutParameter(1, java.sql.Types.VARCHAR);
    entrada.setInt(2, idCita);
    try (ResultSet result = entrada.executeQuery()) {
      while (result.next()) {
        String correito = result.getString("CorreoPaciente");
        correo = correito;
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return correo;
  }
  /**
   * Telefono paciente 
   * @param idCita identificacion cita 
   * @return telefono paciente 
   * @throws SQLException 
   */
  public static String telefonoPacienteFuncionario(int idCita) throws SQLException {
    try (CallableStatement entrada = ConexionSQL.getConnection().prepareCall("{? = call obtenerTelefonoFuncionario(?)}")) {
      entrada.registerOutParameter(1, java.sql.Types.VARCHAR);
      entrada.setInt(2, idCita);
      try (ResultSet result = entrada.executeQuery()) {
        while (result.next()) {
          String num = result.getString("TelefonoPaciente");
          telefono = num;
        }
      } catch (SQLException e) {
        e.printStackTrace();
      }
      return telefono;
    }
  }
  
}
