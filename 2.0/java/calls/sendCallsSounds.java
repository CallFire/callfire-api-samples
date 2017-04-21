import com.callfire.api.client.CallfireClient;
import com.callfire.api.client.api.callstexts.model.Call;
import com.callfire.api.client.api.callstexts.model.CallRecipient;
import com.callfire.api.client.api.callstexts.model.request.SendCallsRequest;
import com.callfire.api.client.api.campaigns.model.Voice;

import java.util.Arrays;
import java.util.List;

class ApiClientSample {
    public static void main(String[] args) {
        CallfireClient client = new CallfireClient("api_login", "api_password");

        CallRecipient r1 = new CallRecipient();
        r1.setPhoneNumber("'12135551100'");
        r1.setLiveMessage("Hello, Alice, this is message for live answer");
        r1.setMachineMessage("Hello, Alice, this is message for answering machine");

        CallRecipient r2 = new CallRecipient();
        r2.setPhoneNumber("''12135551101''");
        r2.setLiveMessage("Hello, Bob, this is message for live answer");
        r2.setMachineMessage("Hello, Bob, this is message for answering machine");

        List<CallRecipient> recipients = Arrays.asList(r1, r2);

        SendCallsRequest request = new SendCallsRequest().create()
            .recipients(recipients)
            .build();

        List<Call> calls = client.callsApi().send(request);
    }
}
