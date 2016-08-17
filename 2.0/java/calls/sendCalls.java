import com.callfire.api.client.CallfireClient;
import com.callfire.api.client.api.callstexts.model.Call;
import com.callfire.api.client.api.callstexts.model.CallRecipient;

import java.util.Arrays;
import java.util.List;

class ApiClientSample {
    public static void main(String[] args) {
        CallfireClient client = new CallfireClient("api_login", "api_password");
        //Only "recipients" param required
        CallRecipient r1 = new CallRecipient();
        r1.setPhoneNumber("12132609784");
        r1.setLiveMessage("Hello");
        r1.setTransferMessage("transferTestMessage");
        //or you can use transfer sound id
        r1.setTransferMessageSoundId(1123123L);
        r1.setTransferNumber("14246525473");
        r1.setTransferDigit("1");
        List<CallRecipient> recipients = Arrays.asList(r1);
        List<Call> calls = client.callsApi().send(recipients);
        // In case you want to send call via existing campaign provide campaign id as second parameter for send() method
        // calls = client.callsApi().send(Arrays.asList(recipient), 60000000003L);
    }
}
