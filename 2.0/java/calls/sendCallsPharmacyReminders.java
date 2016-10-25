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
        r1.getAttributes().put("external_user_id", "45450007002");
        r1.setDialplanXml(buildDialplanXml());

        List<CallRecipient> recipients = Arrays.asList(r1);
        List<Call> calls = client.callsApi().send(recipients);
        // You can send individual calls through particular campaign
        // calls = client.callsApi().send(Arrays.asList(recipient), 60000000003L);
    }

    private static String buildDialplanXml() {
        return
            "<dialplan name=\"Root\">                                                                                  "
                + "    <menu maxDigits=\"1\" timeout=\"3500\" name=\"Live\">                                           "
                + "        <play type=\"tts\" voice=\"female1\">                                                       "
                + "            Hello, this is UMM Health Center, you have an appointment with Dr. Andrew         "
                + "            tomorrow at 3:00 PM, please press 1 to confirm the time or press 2 to reschedule        "
                + "            appointment.                                                                            "
                + "        </play>                                                                                     "
                + "    <keypress pressed=\"1\">                                                                        "
                + "        <!-- user pressed 1, store this data in 'selected_menu' variable -->                        "
                + "        <stash varname=\"selected_menu\">confirmed</stash>                                          "
                + "        <goto>bye_tts</goto>                                                                        "
                + "    </keypress>                                                                                     "
                + "    <keypress pressed=\"2\">                                                                        "
                + "        <!-- user pressed 2, store this data in 'selected_menu' variable -->                        "
                + "        <stash varname=\"selected_menu\">reschedule</stash>                                         "
                + "        <play type=\"tts\" voice=\"female1\">                                                       "
                + "            You will be transferred to our representative to reschedule an appointment. Please wait."
                + "        </play>                                                                                     "
                + "        <transfer callerid=\"${call.callerid}\" musiconhold=\"blues\" mode=\"ringall\">             "
                + "            15550005500                                                                             "
                + "        </transfer>                                                                                 "
                + "    </keypress>                                                                                     "
                + "    <!-- if pressed key is not specified in menu replay Live menu -->                               "
                + "    <keypress pressed=\"default\" name=\"incorrect_Selection\">                                     "
                + "        <play type=\"tts\" voice=\"female1\">That is not a valid selection. Please try again.</play>"
                + "        <goto name=\"replay_Live\">Live</goto>                                                      "
                + "    </keypress>                                                                                     "
                + "</menu>                                                                                             "
                + "<play type=\"tts\" voice=\"female1\" name=\"bye_tts\">                                              "
                + "    Thank you for your response. Have a good day.                                                   "
                + "</play>                                                                                             "
                + "<hangup name=\"Hangup\"/>                                                                           "
                + "</dialplan>                                                                                         ";
    }
}
