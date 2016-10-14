
import com.callfire.api.client.CallfireClient;
import com.callfire.api.client.api.campaigns.model.CallBroadcast;
import com.callfire.api.client.api.campaigns.model.DayOfWeek;
import com.callfire.api.client.api.campaigns.model.LocalDate;
import com.callfire.api.client.api.campaigns.model.LocalTime;
import com.callfire.api.client.api.campaigns.model.Schedule;

import java.util.Arrays;
import java.util.HashSet;

/**
 * An Example how update broadcast and set multiple schedule to
 * start-stop campaign twice in December
 */
class ApiClientSample {
    public static void main(String[] args) {
        CallfireClient client = new CallfireClient("api_login", "api_password");

        CallBroadcast broadcast = new CallBroadcast();
        // set id of an existing broadcast, you can use find() method to search
        //  for particular broadcast id
        broadcast.setId(100400003L);
        // schedule a campaign to run on Saturday and Sunday between 2016-12-01 10:00:00
        //  and 2016-12-10 18:00:00
        Schedule schedule1 = new Schedule();
        schedule1.setStartDate(new LocalDate(2016, 12, 1));
        schedule1.setStartTimeOfDay(new LocalTime(10, 0, 0));
        schedule1.setStopDate(new LocalDate(2016, 12, 10));
        schedule1.setStopTimeOfDay(new LocalTime(18, 0, 0));
        schedule1.setDaysOfWeek(new HashSet<>(Arrays.asList(DayOfWeek.SATURDAY, DayOfWeek.SUNDAY)));
        // set optional time zone, if leave empty account's timezone will be used
        schedule1.setTimeZone("America/New_York");
        // add another schedule for campaign to start on Saturday and Sunday between 2016-12-20 10:00:00
        //  and 2016-12-30 18:00:00
        Schedule schedule2 = new Schedule();
        schedule2.setStartDate(new LocalDate(2016, 12, 20));
        schedule2.setStartTimeOfDay(new LocalTime(10, 0, 0));
        schedule2.setStopDate(new LocalDate(2016, 12, 30));
        schedule2.setStopTimeOfDay(new LocalTime(18, 0, 0));
        schedule2.setDaysOfWeek(new HashSet<>(Arrays.asList(DayOfWeek.SATURDAY, DayOfWeek.SUNDAY)));
        broadcast.setSchedules(Arrays.asList(schedule1, schedule2));

        // update broadcast
        client.callBroadcastsApi().update(broadcast);
        // if it's in 'Stopped' state you need to start it to apply the schedule
        // client.callBroadcastsApi().start(broadcast.getId());
    }
}

