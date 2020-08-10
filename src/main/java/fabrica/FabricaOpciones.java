package fabrica;

import java.util.ArrayList;

public class FabricaOpciones {
  
    /**
     * Obtener opciones de los funcionarios 
     * @param tipoUsuario
     * @return opciones de acuerdo a los funcionarios 
     */
  public static ArrayList<String> getOpciones(String tipoUsuario) {
    switch(tipoUsuario) {
      case "Paciente":
        return opcionesPaciente();
      case "Doctor":
        return opcionesDoctor();
      case "Enfermero":
        return opcionesEnfermero();
      default:
        return opcionesSecretario();
    }
  }
  /**
   * Opciones del paciente
   * @return se dan las opciones al paciente 
   */
  private static ArrayList<String> opcionesPaciente() {
    ArrayList<String> opciones = new ArrayList();
    opciones.add("Solicitar cita");
    opciones.add("Cancelar cita");
    opciones.add("Citas asociadas al paciente");
    opciones.add("Diagnosticos asociados al paciente");
    opciones.add("Tratamientos asociados al paciente");
    opciones.add("Hospitalizaciones registradas al paciente");
    return opciones;
  }
  
  /**
   * Opciones del doctor
   * @return se dan las opciones al doctor 
   */
  private static ArrayList<String> opcionesDoctor() {
    ArrayList<String> opciones = new ArrayList();
    opciones.add("Cancelar cita de paciente");
    opciones.add("Asignar cita a paciente");
    opciones.add("Atender cita");
    opciones.add("Citas registradas en el sistema");
    opciones.add("Diagnosticos asociados a un paciente");
    opciones.add("Tratamientos asociados a un paciente");
    opciones.add("Cantidad de citas registradas en el sistema");
    opciones.add("Cantidad de diagnosticos");
    opciones.add("Cantidad de tratamientos");
    opciones.add("Detalle de hospitalizacion de un paciente");
    opciones.add("Añadir centros de atencion");
    opciones.add("Añadir tipos de centros de atencion");
    opciones.add("Gestionar areas o especialidades");
    opciones.add("Gestionar catalogo de diagnosticos");
    opciones.add("Gestionar catalogo de tratamientos");
    opciones.add("Ver bitacora");
    opciones.add("Hospitalizar");
    opciones.add("Realizar seguimiento");
    return opciones;
  }
  
  /**
   * Opciones del enfermero
   * @return se dan las opciones al enfermero  
   */
  private static ArrayList<String> opcionesEnfermero() {
     ArrayList<String> opciones = new ArrayList();
    opciones.add("Cancelar cita de paciente");
    opciones.add("Asignar cita a paciente");
    opciones.add("Citas registradas en el sistema");
    opciones.add("Diagnosticos asociados a un paciente");
    opciones.add("Cantidad de citas registradas en el sistema");
    opciones.add("Cantidad de diagnosticos");
    opciones.add("Cantidad de tratamientos");
    opciones.add("Detalle de hospitalizacion de un paciente");
    opciones.add("Añadir centros de atencion");
    opciones.add("Añadir tipos de centros de atencion");
    opciones.add("Gestionar areas o especialidades");
    opciones.add("Gestionar catalogo de diagnosticos");
    opciones.add("Gestionar catalogo de tratamientos");
    opciones.add("Ver bitacora");
    opciones.add("Hospitalizar");
    opciones.add("Realizar seguimiento");
    return opciones;
  }
  
  /**
   * Opciones del secretario
   * @return se dan las opciones al secretario 
   */
  private static ArrayList<String> opcionesSecretario() {
    ArrayList<String> opciones = new ArrayList();
    opciones.add("Cancelar cita de paciente");
    opciones.add("Asignar cita a paciente");
    opciones.add("Citas registradas en el sistema");
    opciones.add("Hospitalizaciones registradas");
    opciones.add("Añadir centros de atencion");
    opciones.add("Añadir tipos de centros de atencion");
    opciones.add("Gestionar areas o especialidades");
    opciones.add("Gestionar catalogo de diagnosticos");
    opciones.add("Gestionar catalogo de tratamientos");
    opciones.add("Ver bitacora");
    return opciones;
  }
  
}
