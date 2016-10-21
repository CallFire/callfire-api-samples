
import com.callfire.api.client.CallfireClient;
import com.callfire.api.client.api.campaigns.model.CallBroadcast;
import com.callfire.api.client.api.campaigns.model.DayOfWeek;
import com.callfire.api.client.api.campaigns.model.LocalDate;
import com.callfire.api.client.api.campaigns.model.LocalTime;
import com.callfire.api.client.api.campaigns.model.LocalTimeRestriction;
import com.callfire.api.client.api.campaigns.model.Schedule;

import java.util.Arrays;
import java.util.HashSet;

class ApiClientSample {
    public static void main(String[] args) {
        CallfireClient client = new CallfireClient("api_login", "api_password");
        CallBroadcast broadcast = client.callBroadcastsApi().get(123L);
        // time restrictions
        LocalTimeRestriction restrictions = new LocalTimeRestriction();
        restrictions.setBeginHour(10);
        restrictions.setBeginMinute(10);
        restrictions.setEndHour(22);
        restrictions.setEndMinute(0);
        restrictions.setEnabled(true);

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

        broadcast.setLocalTimeRestriction(restrictions);
        broadcast.getSchedules().add(schedule);
        // update campaign
        client.callBroadcastsApi().update(broadcast);
    }
}
