package mensaje;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

/**
 *
 * @author Miranda Venegas
 */
public class Mensaje {
  
  private static final String ACCOUNT_SID = "AC69c8cf37a71f7dc1f7c9ee1ef3a4202d";
  private static final String AUTH_TOKEN = "e3a2af38d9edd89504af5e7082862b13";
  private static final String NUMBER = "+16606285744";
  
  public static void enviarMensaje(String telefono, String mensaje) {
    Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
    PhoneNumber to = new PhoneNumber(telefono);
    PhoneNumber from = new PhoneNumber(NUMBER);
    Message.creator(to, from, mensaje).create();
  }
  
}
