package generico;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;

/**
 *
 * @author Miranda Venegas, Amanda Castro 
 * @param <E>
 */
public class Tabla<E> {
  
  private final ArrayList<E> elementos;
  private final ArrayList<String> columnas;
  
  public Tabla() {
    elementos = new ArrayList<>();
    columnas = new ArrayList<>();
  }
  
  public ArrayList<E> obtenerElementos() {
    return elementos;
  }
  
  public ArrayList<String> obtenerColumnas() {    
    return columnas;
  }
  
  public int obtenerLargo() {
    return elementos.size();
  }
  
  public void agregar(E valor) {
    elementos.add(valor);
    if(columnas.isEmpty()) {
      obtenerColumnas(valor);
    }
  }
 
  /**
   * obtener campos 
   * @param indice
   * @return numero de campos 
   * @throws Exception 
   */
  public ArrayList<Object> obtenerCampos(int indice) throws Exception {
    ArrayList<Object> campos = new ArrayList<>();
    Object valor = elementos.get(indice);
    Class<?> c = valor.getClass();
    for(String columna: columnas) {
      try {
        Method metodo = c.getMethod("get" + columna);
        Object campo = metodo.invoke(valor);
        campos.add(campo);
      } catch (NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException | InvocationTargetException ex) {
        throw new Exception("El atributo no es accesible o visible", ex);
      }
    }
    return campos;
  }
  
  /**
   * obtener columnas 
   * @param valor 
   */
  private void obtenerColumnas(E valor) {
    Class<?> clazz = valor.getClass();
    for(Field field : clazz.getDeclaredFields()) {
      String columna = field.getName();
      columna = columna.substring(0, 1).toUpperCase() + columna.substring(1);
      columnas.add(columna);
    }
  }
  
}
