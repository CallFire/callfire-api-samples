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
        config.setConfigType(NumberConfig.ConfigType.TRACKING);
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

        config.setCallTrackingConfig(callTrackingConfig);
        client.numberLeasesApi().updateConfig(config);
    }
}
