import com.callfire.api.client.CallfireClient;
import com.callfire.api.client.api.numbers.model.IvrInboundConfig;
import com.callfire.api.client.api.numbers.model.NumberConfig;

class ApiClientSample {
    public static void main(String[] args) {
        CallfireClient client = new CallfireClient("api_login", "api_password");
        NumberConfig config = new NumberConfig();
        config.setNumber("16502572135");
        config.setConfigType(NumberConfig.ConfigType.IVR);
        // create IVR config
        IvrInboundConfig ivrInboundConfig = new IvrInboundConfig();
        ivrInboundConfig.setDialplanXml(buildDialplanXml());
        config.setIvrInboundConfig(ivrInboundConfig);
        // update number configuration
        client.numberLeasesApi().updateConfig(config);
    }

    private static String buildDialplanXml() {
        return
            " <dialplan name=\"Root\">                                                                                        "
                + " <menu maxDigits=\"1\" timeout=\"3500\" name=\"Live\">                                                     "
                + "     <play type=\"tts\" voice=\"female1\">                                                                 "
                + "         Hello this is AB Advertising, please press 1 to transfer to our sales representative,              "
                + "         press 2 to contact clients support.                                                               "
                + "      </play>                                                                                              "
                + "      <keypress pressed=\"1\">                                                                             "
                + "          <!-- user pressed 1, store this data in 'selected_menu' variable -->                             "
                + "          <stash varname=\"selected_menu\">sales</stash>                                                   "
                + "          <play type=\"tts\" voice=\"female1\">                                                            "
                + "              You will be transferred to sales representative in a moment. Please wait.                    "
                + "          </play>                                                                                          "
                + "          <transfer callerid=\"${call.callerid}\" musiconhold=\"blues\" mode=\"ringall\">                  "
                + "              15550004455                                                                                  "
                + "          </transfer>                                                                                      "
                + "          </keypress>                                                                                      "
                + "          <keypress pressed=\"2\" name=\"kp_become_volonteer\">                                            "
                + "              <!-- user pressed 2, store this data in 'selected_menu' variable -->                         "
                + "              <stash varname=\"selected_menu\">support</stash>                                             "
                + "              <play type=\"tts\" voice=\"female1\">                                                        "
                + "                  You will be transferred to clients support. Please wait.                                 "
                + "              </play>                                                                                      "
                + "              <transfer callerid=\"${call.callerid}\" musiconhold=\"blues\" mode=\"ringall\">              "
                + "                  15550005500                                                                              "
                + "              </transfer>                                                                                  "
                + "           </keypress>                                                                                     "
                + "           <!-- if pressed key is not specified in menu replay Live menu -->                               "
                + "           <keypress pressed=\"default\" name=\"incorrect_Selection\">                                     "
                + "               <play type=\"tts\" voice=\"female1\">That is not a valid selection. Please try again.</play>"
                + "               <goto name=\"replay_Live\">Live</goto>                                                      "
                + "           </keypress>                                                                                     "
                + " </menu>                                                                                                   "
                + " <play type=\"tts\" voice=\"female1\">                                                                     "
                + "     Thank you for calling us. Have a good day.                                                            "
                + " </play>                                                                                                   "
                + " <hangup name=\"Hangup\"/>                                                                                 "
                + " </dialplan>                                                                                               ";
    }
}
