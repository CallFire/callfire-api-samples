import com.callfire.api.client.CallfireClient;
import com.callfire.api.client.api.campaigns.model.AnsweringMachineConfig;
import com.callfire.api.client.api.campaigns.model.CallBroadcast;
import com.callfire.api.client.api.campaigns.model.CallBroadcastSounds;
import com.callfire.api.client.api.campaigns.model.LocalTimeRestriction;
import com.callfire.api.client.api.campaigns.model.RetryConfig;
import com.callfire.api.client.api.campaigns.model.RetryConfig.RetryPhoneTypes;
import com.callfire.api.client.api.campaigns.model.RetryConfig.RetryResults;
import com.callfire.api.client.api.campaigns.model.Schedule;
import com.callfire.api.client.api.common.model.LocalDate;
import com.callfire.api.client.api.common.model.LocalTime;
import com.callfire.api.client.api.common.model.ResourceId;

import java.time.DayOfWeek;
import java.util.Arrays;
import java.util.HashSet;

class CreateVoiceBroadcastSample {

    public static void main(String[] args) {
        CallfireClient client = new CallfireClient("api_login", "api_password");
        CallBroadcast broadcast = new CallBroadcast();
        broadcast.setName("Call Broadcast");
        // attach custom labels if needed
        broadcast.setLabels(Arrays.asList("voice tag", "id-10002"));
        // set validated Caller ID number. 
        broadcast.setFromNumber("12135551189");
        // set answering machine detection
        broadcast.setAnsweringMachineConfig(AnsweringMachineConfig.AM_AND_LIVE);

        // set voice messages using TTS option for Live answers and when Answering Machine is detected.
        // you also can set a pre-defined TTS voice.
        CallBroadcastSounds sounds = new CallBroadcastSounds();
        sounds.setLiveSoundText("Hello! This is a live answer text to speech recording");
        sounds.setMachineSoundText("This is an answering machine text to speech recording");
        broadcast.setSounds(sounds);

        // allow CallFire to dial recipient only between 09:00 - 18:00 depending on
        //  recipient's number area code timezone
        LocalTimeRestriction timeRestriction = new LocalTimeRestriction();
        timeRestriction.setBeginHour(9);
        timeRestriction.setBeginMinute(0);
        timeRestriction.setEndHour(18);
        timeRestriction.setEndMinute(0);
        broadcast.setLocalTimeRestriction(timeRestriction);

        // set retry configuration to attempt a contact's Mobile and Work phone numbers twice in case Call was 
        //  resulted to BUSY or No Answer response. Set 5 minutes between attempts.  
        RetryConfig retryConfig = new RetryConfig();
        retryConfig.setMaxAttempts(2);
        retryConfig.setMinutesBetweenAttempts(5);
        retryConfig.setRetryResults(Arrays.asList(RetryResults.BUSY, RetryResults.NO_ANS));
        retryConfig.setRetryPhoneTypes(Arrays.asList(RetryPhoneTypes.MOBILE_PHONE, RetryPhoneTypes.WORK_PHONE));
        broadcast.setRetryConfig(retryConfig);

        // schedule a campaign to run on every Monday and Wednesday starting from 2016-12-01 10:00:00 
        Schedule schedule = new Schedule();
        schedule.setStartDate(new LocalDate(2016, 12, 1));
        schedule.setStartTimeOfDay(new LocalTime(10, 0, 0));
        // set weekly schedule
        schedule.setDaysOfWeek(new HashSet<>(Arrays.asList(DayOfWeek.MONDAY, DayOfWeek.WEDNESDAY)));
        // set optional time zone, if leave empty account's timezone will be used 
        schedule.setTimeZone("America/New_York");
        broadcast.setSchedules(Arrays.asList(schedule));

        // create broadcast with 'start' argument = true to start campaign immediately
        ResourceId id = client.callBroadcastsApi().create(broadcast);

        System.out.println(id);
    }
}
