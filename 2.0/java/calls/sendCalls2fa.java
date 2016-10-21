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
        r1.setPhoneNumber("12135551100");
        r1.setDialplanXml(buildDialplanXml());

        List<CallRecipient> recipients = Arrays.asList(r1);
        List<Call> calls = client.callsApi().send(recipients);
        // In case you want to send call via existing campaign provide campaign id as second parameter for send() method
        // calls = client.callsApi().send(Arrays.asList(recipient), 60000000003L);
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
                + "     <play type=\"tts\" voice=\"female1\" name=\"play_code\">Hello, your one-time code is 2 5 1 7, press 1 to repeat.</play>"
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
