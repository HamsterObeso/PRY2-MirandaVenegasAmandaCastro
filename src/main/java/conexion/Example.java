package conexion;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

public class Example {
  // Find your Account Sid and Token at twilio.com/user/account
  public static final String ACCOUNT_SID = "ACb0102705c4599e19c6c61a51d9a4f3e6";
  public static final String AUTH_TOKEN = "efd1c028573bdbb2684f1c2804c8144f";

  public static void main(String[] args) {
    Twilio.init(ACCOUNT_SID, AUTH_TOKEN);

    Message message = Message.creator(new PhoneNumber("+50685236688"),
        new PhoneNumber("+17206369419"), 
        "LA VIRGEN DE LA PAPAYA").create();

    System.out.println(message.getSid());
  }
}
