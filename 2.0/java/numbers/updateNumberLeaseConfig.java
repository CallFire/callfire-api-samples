import com.callfire.api.client.CallfireClient;
import com.callfire.api.client.api.common.model.LocalTime;
import com.callfire.api.client.api.common.model.WeeklySchedule;
import com.callfire.api.client.api.numbers.model.CallTrackingConfig;
import com.callfire.api.client.api.numbers.model.GoogleAnalytics;
import com.callfire.api.client.api.numbers.model.NumberConfig;

import java.time.DayOfWeek;
import java.util.Arrays;
import java.util.HashSet;

class ApiClientSample {
    public static void main(String[] args) {
        CallfireClient client = new CallfireClient("api_login", "api_password");
        NumberConfig config = new NumberConfig();
        config.setNumber("'19206596476'");
        // create call tracking config
        CallTrackingConfig callTrackingConfig = new CallTrackingConfig();
        callTrackingConfig.setScreen(false);
        callTrackingConfig.setRecorded(true);
        callTrackingConfig.setRecorded(true);
        callTrackingConfig.setVoicemail(true);
        callTrackingConfig.setIntroSoundId(10004001L);
        callTrackingConfig.setWhisperSoundId(10005002L);
        callTrackingConfig.setVoicemailSoundId(10006003L);
        callTrackingConfig.setFailedTransferSoundId(10007004L);
        callTrackingConfig.setTransferNumbers(Arrays.asList("'12135551122", "'12135551189'"));

        WeeklySchedule schedule = new WeeklySchedule();
        schedule.setStartTimeOfDay(new LocalTime(10, 0, 0));
        schedule.setStopTimeOfDay(new LocalTime(18, 0, 0));
        schedule.setDaysOfWeek(new HashSet<>(
                Arrays.asList(DayOfWeek.MONDAY, DayOfWeek.TUESDAY, DayOfWeek.THURSDAY, DayOfWeek.WEDNESDAY, DayOfWeek.FRIDAY)));
        schedule.setTimeZone("America/New_York");
        callTrackingConfig.setWeeklySchedule(schedule);

        GoogleAnalytics googleAnalytics = new GoogleAnalytics();
        googleAnalytics.setDomain("domain - name");
        googleAnalytics.setCategory("Sales");
        googleAnalytics.setGoogleAccountId("UA - XXXXX - 2X");
        callTrackingConfig.setGoogleAnalytics(googleAnalytics);

        // create IVR config
        // IvrInboundConfig ivrInboundConfig = new IvrInboundConfig();
        // ivrInboundConfig.setDialplanXml(buildDialplanXml());
        // config.setIvrInboundConfig(ivrInboundConfig);
        // config.setConfigType(NumberConfig.ConfigType.IVR);

        // depends on what type of configuration your need assign TRACKING or IVR config
        config.setConfigType(NumberConfig.ConfigType.TRACKING);
        config.setCallTrackingConfig(callTrackingConfig);
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
