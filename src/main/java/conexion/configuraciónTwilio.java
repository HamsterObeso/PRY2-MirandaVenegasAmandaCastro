package conexion;

import org.springframework.context.annotation.Configuration;

@Configuration
public class configuraciónTwilio {

    private String accountSid= "ACb0102705c4599e19c6c61a51d9a4f3e6";
    private String authToken="efd1c028573bdbb2684f1c2804c8144f";
    private String trialNumber="+17206369419";

    

    public configuraciónTwilio() {

    }

    public String getAccountSid() {
        return accountSid;
    }

    public void setAccountSid(String accountSid) {
        this.accountSid = accountSid;
    }

    public String getAuthToken() {
        return authToken;
    }

    public void setAuthToken(String authToken) {
        this.authToken = authToken;
    }

    public String getTrialNumber() {
        return trialNumber;
    }

    public void setTrialNumber(String trialNumber) {
        this.trialNumber = trialNumber;
    }
}


































