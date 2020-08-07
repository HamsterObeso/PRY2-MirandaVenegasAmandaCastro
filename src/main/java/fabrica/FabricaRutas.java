package fabrica;

/**
 *
 * @author Miranda Venegas
 */
public class FabricaRutas {
  
  public static String getRuta(String opcion) {
    switch(opcion) {
      case "Solicitar cita":
        return "solicitarCita";
      case "Cancelar cita":
        return "cancelarCita";
      case "Citas asociadas al paciente":
        return "solicitarCita";
      case "Diagnosticos asociados al paciente":
        return "solicitarCita";
      case "Tratamientos asociados al paciente":
        return "solicitarCita";
      case "Hospitalizaciones registradas al paciente":
        return "solicitarCita";
      case "Cancelar cita de paciente":
        return "solicitarCita";
      case "Asignar cita a paciente":
        return "solicitarCita";
      case "Atender cita":
        return "solicitarCita";
      case "Citas registradas en el sistema":
        return "solicitarCita";
      case "Diagnosticos asociados a un paciente":
        return "solicitarCita";
      case "Cantidad de citas registradas en el sistema":
        return "solicitarCita";
      case "Cantidad de diagnosticos":
        return "solicitarCita";
      case "Cantidad de tratamientos":
        return "solicitarCita";
      case "Detalle de hospitalizacion de un paciente":
        return "solicitarCita";
      case "Añadir centros de atencion":
        return "solicitarCita";
      case "Añadir tipos de centros de atencion":
        return "solicitarCita";
      case "Gestionar areas o especialidades":
        return "solicitarCita";
      case "Gestionar catalogo de diagnosticos":
        return "solicitarCita";
      case "Gestionar catalogo de tratamientos":
        return "solicitarCita";
      case "Ver bitacora":
        return "solicitarCita";
      case "Citas registradas en el sistema E":
        return "solicitarCita";
      case "Hospitalizaciones registradas":
        return "solicitarCita";
        
      default:
        return "menu";
    }
  }
  
}
