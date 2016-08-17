import com.callfire.api.client.CallfireClient;
import com.callfire.api.client.api.callstexts.model.Call;
import com.callfire.api.client.api.campaigns.model.Recipient;

import java.util.Arrays;
import java.util.List;

class ApiClientSample {
    public static void main(String[] args) {
        CallfireClient callfireClient = new CallfireClient("api_login", "api_password");
        Recipient recipient1 = new Recipient();
        recipient1.setPhoneNumber("12131234567");
        Recipient recipient2 = new Recipient();
        recipient2.setPhoneNumber("12131234568");
        List<Recipient> recipients = Arrays.asList(recipient1, recipient2);
        List<Call> calls = callfireClient.callBroadcastsApi().addRecipients(123456L, recipients);
    }
}
