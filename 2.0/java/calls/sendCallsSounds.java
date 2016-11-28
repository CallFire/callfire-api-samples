import com.callfire.api.client.CallfireClient;
import com.callfire.api.client.api.callstexts.model.Call;
import com.callfire.api.client.api.callstexts.model.CallRecipient;

import java.util.Arrays;
import java.util.List;

class ApiClientSample {
    public static void main(String[] args) {
        CallfireClient client = new CallfireClient("api_login", "api_password");

        CallRecipient r1 = new CallRecipient();
        r1.setPhoneNumber("12135551100");
        r1.setLiveMessage("Hello, Alice, this is message for live answer");
        r1.setMachineMessage("Hello, Alice, this is message for answering machine");

        CallRecipient r2 = new CallRecipient();
        r2.setPhoneNumber("12135551101");
        r2.setLiveMessage("Hello, Bob, this is message for live answer");
        r2.setMachineMessage("Hello, Bob, this is message for answering machine");

        List<CallRecipient> recipients = Arrays.asList(r1, r2);
        List<Call> calls = client.callsApi().send(recipients);
        // In case you want to send call via existing campaign provide campaign id as second parameter for send() method
        // calls = client.callsApi().send(Arrays.asList(r1, r2), 60000000003L);
    }
}
