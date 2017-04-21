import com.callfire.api.client.CallfireClient;
import com.callfire.api.client.api.callstexts.model.Call;
import com.callfire.api.client.api.campaigns.model.Recipient;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class ApiClientSample {
    public static void main(String[] args) {
        CallfireClient callfireClient = new CallfireClient("api_login", "api_password");
        Recipient recipient1 = new Recipient();
        recipient1.setPhoneNumber("12135551122");
        Recipient recipient2 = new Recipient();
        recipient2.setContactId(122460000043L);
        Recipient recipient3 = new Recipient();
        recipient3.setPhoneNumber("12135558090");
        Map<String,String> attrs = new HashMap<>();
        attrs.put("custom_external_id", "30005044");
        attrs.put("custom_property_1", "value1");
        recipient3.setAttributes(attrs);
        List<Recipient> recipients = Arrays.asList(recipient1, recipient2, recipient3);
        List<Call> calls = callfireClient.callBroadcastsApi().addRecipients(11646003L, recipients);
    }
}
