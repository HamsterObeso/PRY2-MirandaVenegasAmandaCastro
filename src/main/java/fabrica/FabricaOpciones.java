package fabrica;

import java.util.ArrayList;

public class FabricaOpciones {
  
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
  
  private static ArrayList<String> opcionesDoctor() {
    ArrayList<String> opciones = new ArrayList();
    opciones.add("Cancelar cita de paciente");
    opciones.add("Asignar cita a paciente");
    opciones.add("Atender cita");
    opciones.add("Citas registradas en el sistema");
    opciones.add("Diagnosticos asociados a un paciente");
    opciones.add("Cantidad de citas registradas en el sistema");
    opciones.add("Cantidad de diagnosticos");
    opciones.add("Cantidad de tratamientos");
    opciones.add("Detalle de hospitalizacion de un paciente");
    return opciones;
  }
  
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
    return opciones;
  }
  
  private static ArrayList<String> opcionesSecretario() {
    ArrayList<String> opciones = new ArrayList();
    opciones.add("Cancelar cita de paciente");
    opciones.add("Asignar cita a paciente");
    opciones.add("Citas registradas en el sistema");
    opciones.add("Hospitalizaciones registradas");
    return opciones;
  }
  
}
