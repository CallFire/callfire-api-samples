import com.callfire.api.client.CallfireClient;
import com.callfire.api.client.api.callstexts.model.Call;
import com.callfire.api.client.api.callstexts.model.CallRecipient;
import com.callfire.api.client.api.callstexts.model.request.SendCallsRequest;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class ApiClientSample {
    public static void main(String[] args) {
        CallfireClient client = new CallfireClient("api_login", "api_password");
        CallRecipient r1 = new CallRecipient();
        r1.setPhoneNumber("12135551100");
        r1.setDialplanXml(buildDialplanXml());
        r1.getAttributes().put("external_user_id", "45450007002");
        List<CallRecipient> recipients = Arrays.asList(r1);

        SendCallsRequest request = new SendCallsRequest().create()
            .recipients(recipients)
            .build();

        List<Call> calls = client.callsApi().send(request);
    }

    private static String buildDialplanXml() {
        return
            "<dialplan name=\"Root\">                                                             "
                + "<!-- answering machine detection -->                                           "
                + "<amd>                                                                          "
                + "    <!-- if call is answered by human go to live menu -->                      "
                + "    <live>                                                                     "
                + "        <goto name=\"live\">Live</goto>                                        "
                + "    </live>                                                                    "
                + "     <!-- hangup if answering machine detected -->                             "
                + "     <machine>                                                                 "
                + "         <goto>hangup</goto>                                                   "
                + "     </machine>                                                                "
                + "</amd>                                                                         "
                + " <menu maxDigits=\"1\" timeout=\"3500\" name=\"live\">                         "
                + "     <!-- play text message with secure code -->                               "
                + "     <play type=\"tts\" voice=\"female1\" name=\"play_code\">Hello, ${contact.firstName}, this is CallFire IVR message.</play>"
                + "     <keypress pressed=\"1\">                                                  "
                + "         <goto>live</goto>                                                     "
                + "     </keypress>                                                               "
                + "     <keypress pressed=\"timeout\">                                            "
                + "         <hangup/>                                                             "
                + "     </keypress>                                                               "
                + " </menu>                                                                       "
                + " <hangup name=\"hangup\"/>                                                     "
                + "</dialplan>                                                                    ";
    }
}
