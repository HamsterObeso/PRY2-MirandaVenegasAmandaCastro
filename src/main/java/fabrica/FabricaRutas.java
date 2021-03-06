package fabrica;

/**
 *
 * @author Miranda Venegas, Amanda Castro 
 */
public class FabricaRutas {
  
    /**
     * Obtener la ruta de las opciones 
     * @param opcion opcion solicitada
     * @return opción solicitada
     */
  public static String getRuta(String opcion) {
    switch(opcion) {
      case "Solicitar cita":
        return "solicitarCita";
      case "Cancelar cita":
        return "cancelarCita";
      case "Citas asociadas al paciente":
        return "citasPaciente";
      case "Diagnosticos asociados al paciente":
        return "diagnosticosPaciente";
      case "Tratamientos asociados al paciente":
        return "tratamientosPaciente";
      case "Hospitalizaciones registradas al paciente":
        return "hospitalizacionPaciente";
      case "Cancelar cita de paciente":
        return "cancelarCita";
      case "Asignar cita a paciente":
        return "asignarCita";
      case "Atender cita":
        return "atenderCita";
      case "Citas registradas en el sistema":
        return "citasSistemaDocEnf";
      case "Diagnosticos asociados a un paciente":
        return "diagnosticosDocEnf";
      case "Tratamientos asociados a un paciente":
        return "tratamientosDocEnf";
      case "Cantidad de citas registradas en el sistema":
        return "cantidadCitas";
      case "Cantidad de diagnosticos":
        return "cantidadDiagnosticos";
      case "Cantidad de tratamientos":
        return "cantidadTratamientos";
      case "Detalle de hospitalizacion de un paciente":
        return "detalleHospitalizacion";
      case "Añadir centros de atencion":
        return "agregarCentro";
      case "Añadir tipos de centros de atencion":
        return "agregarTipoCentro";
      case "Gestionar areas o especialidades":
        return "gestionEspecialidad";
      case "Gestionar catalogo de diagnosticos":
        return "gestionDiagnostico";
      case "Gestionar catalogo de tratamientos":
        return "gestionTratamiento";
      case "Ver bitacora":
        return "cargarBitacora";
      case "Hospitalizaciones registradas":
        return "hospitalizacionesRegistradas";
      case "Hospitalizar":
        return "hospitalizar";
      case "Realizar seguimiento":
        return "realizarSeguimiento";
      default:
        return "menu";
    }
  }
  
}
