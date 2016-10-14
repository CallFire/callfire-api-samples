import com.callfire.api.client.CallfireClient;
import com.callfire.api.client.api.campaigns.model.AnsweringMachineConfig;
import com.callfire.api.client.api.campaigns.model.CallBroadcast;
import com.callfire.api.client.api.campaigns.model.CallBroadcastSounds;
import com.callfire.api.client.api.campaigns.model.DayOfWeek;
import com.callfire.api.client.api.campaigns.model.LocalDate;
import com.callfire.api.client.api.campaigns.model.LocalTime;
import com.callfire.api.client.api.campaigns.model.LocalTimeRestriction;
import com.callfire.api.client.api.campaigns.model.Recipient;
import com.callfire.api.client.api.campaigns.model.RetryConfig;
import com.callfire.api.client.api.campaigns.model.RetryConfig.RetryPhoneTypes;
import com.callfire.api.client.api.campaigns.model.RetryConfig.RetryResults;
import com.callfire.api.client.api.campaigns.model.Schedule;
import com.callfire.api.client.api.campaigns.model.Voice;
import com.callfire.api.client.api.common.model.ResourceId;

import java.util.Arrays;
import java.util.HashSet;

/**
 * Example shows how to schedule a voice broadcast in a single call
 * and send a voice message to 3 recipients
 */
class CreateVoiceBroadcastSample {

    public static void main(String[] args) {
        CallfireClient client = new CallfireClient("api_login", "api_password");
        CallBroadcast broadcast = new CallBroadcast();
        broadcast.setName("Charity Campaign");
        // attach custom labels if needed
        broadcast.setLabels(Arrays.asList("charity", "id-10002"));
        // set validated Caller ID number. 
        broadcast.setFromNumber("12135551189");
        // set answering machine detection
        broadcast.setAnsweringMachineConfig(AnsweringMachineConfig.AM_AND_LIVE);

        // set voice messages using TTS option for Live answers and when Answering Machine is detected.
        // you also can set a pre-defined TTS voice.
        CallBroadcastSounds sounds = new CallBroadcastSounds();
        sounds.setLiveSoundText("Hello, this is Mary, from the local branch of Non-profit agency." +
            "Don't miss our charity weekend taking place at first November weekends. We are " +
            "looking forward to meet you there. Press '1' to to find out more details.");
        sounds.setLiveSoundTextVoice(Voice.MALE1);
        sounds.setMachineSoundText("Hello, this is Mary, from the local branch of Non-profit agency." +
            "If you are interested in charity weekend, please call (231) 455-7676.");
        sounds.setMachineSoundTextVoice(Voice.MALE1);
        sounds.setTransferDigit("1");
        // set number to transfer call to once transfer digit is pressed
        sounds.setTransferNumber("12314557676");
        sounds.setTransferSoundText("Please wait a moment, call is being transfer.");
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

        // add new recipients
        Recipient recipient1 = new Recipient();
        recipient1.setPhoneNumber("12135551100");
        // set custom recipient attributes, they are available only to a single Call/Text
        //  action, do not confuse them with contact fields which are stored with contact and are available to
        //  each Call/Text where contact is attached to
        recipient1.getAttributes().put("age", "30");
        recipient1.getAttributes().put("position", "Manager");

        Recipient recipient2 = new Recipient();
        recipient2.setPhoneNumber("12135551101");
        recipient2.getAttributes().put("external_system_id", "34347770001");
        recipient2.getAttributes().put("call_label", "friends");

        // You can use already existing contacts as a recipients
        Recipient recipient3 = new Recipient();
        recipient3.setContactId(46000044001L);

        broadcast.setRecipients(Arrays.asList(recipient1, recipient2, recipient3));

        // create broadcast with 'start' argument = true to start campaign immediately
        ResourceId id = client.callBroadcastsApi().create(broadcast, false);

        System.out.println(id);
    }
}

