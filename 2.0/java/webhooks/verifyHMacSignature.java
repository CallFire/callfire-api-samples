import java.security.SignatureException;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.binary.Base64;

public class ApiRequestVerifier {

    public String getHmacSignature(String data, String key) throws SignatureException {
        String result;
        SecretKeySpec signingKey = new SecretKeySpec(key.getBytes(), "HmacSHA1");
        Mac mac;
        try {
            mac = Mac.getInstance("HmacSHA1");
            mac.init(signingKey);
            byte[] rawHmac = mac.doFinal(data.getBytes());
            result = Base64.encodeBase64String(rawHmac).trim();
        } catch (Exception e) {
            throw new SignatureException("Failed to generate HMAC : " + e.getMessage());
        }
        return result;
    }
}

// then check signature in listener code
// String data = "{\"name\":\"test webhook\", \"callback\":\"sms:callfire\"}";
// String secret = "mysecrets";
// Assert.assertEquals("v14pF7d5C1+CHNIEWlg+sw9v0Xg=", new ApiRequestVerifier().getHmacSignature(data, secret));
