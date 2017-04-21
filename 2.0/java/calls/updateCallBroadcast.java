
import com.callfire.api.client.CallfireClient;
import com.callfire.api.client.api.campaigns.model.AnsweringMachineConfig;
import com.callfire.api.client.api.campaigns.model.CallBroadcast;
import com.callfire.api.client.api.campaigns.model.CallBroadcastSounds;
import com.callfire.api.client.api.campaigns.model.Schedule;
import com.callfire.api.client.api.common.model.LocalDate;
import com.callfire.api.client.api.common.model.LocalTime;

import java.time.DayOfWeek;
import java.util.Arrays;
import java.util.HashSet;

class ApiClientSample {
    public static void main(String[] args) {
        CallfireClient client = new CallfireClient("api_login", "api_password");
        CallBroadcast broadcast = new CallBroadcast();

        // add schedule to a campaign to run on Saturday and Sunday between 2016-12-01 10:00:00
        //  and 2016-12-10 18:00:00
        Schedule schedule = new Schedule();
        schedule.setStartDate(new LocalDate(2016, 12, 1));
        schedule.setStartTimeOfDay(new LocalTime(10, 0, 0));
        schedule.setStopDate(new LocalDate(2016, 12, 10));
        schedule.setStopTimeOfDay(new LocalTime(18, 0, 0));
        schedule.setDaysOfWeek(new HashSet<>(Arrays.asList(DayOfWeek.SATURDAY, DayOfWeek.SUNDAY)));
        // set optional time zone, if leave empty account's timezone will be used
        schedule.setTimeZone("America/New_York");

        broadcast.getSchedules().add(schedule);

        broadcast.setId(11646003L);
        broadcast.setName("Call Broadcast with Schedules");
        broadcast.setAnsweringMachineConfig(AnsweringMachineConfig.LIVE_IMMEDIATE);
        CallBroadcastSounds sounds = new CallBroadcastSounds();
        sounds.setLiveSoundText("Hello! This is an updated Call Broadcast config tts");
        broadcast.setSounds(sounds);

        // update campaign
        client.callBroadcastsApi().update(broadcast);
    }
}
