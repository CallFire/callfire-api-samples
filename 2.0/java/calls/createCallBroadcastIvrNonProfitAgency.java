package com.callfire.api.client.integration;

import com.callfire.api.client.CallfireClient;
import com.callfire.api.client.api.campaigns.model.CallBroadcast;
import com.callfire.api.client.api.campaigns.model.DayOfWeek;
import com.callfire.api.client.api.campaigns.model.LocalDate;
import com.callfire.api.client.api.campaigns.model.LocalTime;
import com.callfire.api.client.api.campaigns.model.LocalTimeRestriction;
import com.callfire.api.client.api.campaigns.model.Recipient;
import com.callfire.api.client.api.campaigns.model.RetryConfig;
import com.callfire.api.client.api.campaigns.model.RetryConfig.RetryPhoneTypes;
import com.callfire.api.client.api.campaigns.model.RetryConfig.RetryResults;
import com.callfire.api.client.api.campaigns.model.Schedule;
import com.callfire.api.client.api.common.model.ResourceId;

import java.util.Arrays;
import java.util.HashSet;

class CreateVoiceBroadcastSample {

    public static void main(String[] args) {
        CallfireClient client = new CallfireClient("api_login", "api_password");
        CallBroadcast broadcast = new CallBroadcast();
        broadcast.setName("Charity Campaign");
        // attach custom labels if needed
        broadcast.setLabels(Arrays.asList("charity", "id-10002"));
        // set validated Caller ID number. 
        broadcast.setFromNumber("12135551189");
        // add IVR XML
        broadcast.setDialplanXml(buildDialplanXml());

        // allow CallFire to dial recipient only between 09:00 - 18:00 depending on
        //  recipient's number area code timezone
        LocalTimeRestriction timeRestriction = new LocalTimeRestriction();
        timeRestriction.setBeginHour(10);
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
        ResourceId id = client.callBroadcastsApi().create(broadcast, true);

        System.out.println(id);
    }

    private static String buildDialplanXml() {
        return
            "<dialplan name=\"Root\">                                                             "
                + "<!-- answering machine detection -->                                           "
                + "<amd>                                                                          "
                + "    <!-- if call is answered by human go to live menu -->                      "
                + "    <live>                                                                     "
                + "        <goto name=\"goto_Live\">Live</goto>                                   "
                + "    </live>                                                                    "
                + "    <machine>                                                                  "
                + "        <goto name=\"goto_Machine\">Machine</goto>                             "
                + "    </machine>                                                                 "
                + "</amd>                                                                         "
                + "<menu maxDigits=\"1\" timeout=\"3500\" name=\"Live\">                          "
                + "    <play type=\"tts\" voice=\"female1\" name=\"play_Live\">                   "
                + "Hello ${contact.firstName}, we are organizing a charity weekend in November.   "
                + "Don't miss to visit it. Press \"1\" to follow the instructions how to order the"
                + "tickets, press \"2\" if you are willing to become a volunteer at event.        "
                + "    </play>                                                                    "
                + "<keypress pressed=\"1\" name=\"kp_order_tickets\">                             "
                + "    <!-- store recipient's answer and go to another menu to make a purchase -->"
                + "    <stash varname=\"order\" name=\"create_an_order\">Yes</stash>              "
                + "    <goto>order_tickets</goto>                                                 "
                + "</keypress>                                                                    "
                + "<keypress pressed=\"2\" name=\"kp_become_volonteer\">                          "
                + "    <!-- store recipient's answer -->                                          "
                + "    <stash varname=\"volonteer\" name=\"become_volonteer\">Yes</stash>         "
                + "    <play type=\"tts\" voice=\"female1\" name=\"play_Goodbye_1\">Thanks for the"
                + "        Thanks for the response. We will call you later today.                 "
                + "    </play>                                                                    "
                + "    <goto>Hangup</goto>                                                        "
                + "</keypress>                                                                    "
                + "<!-- if pressed key is not specified in menu replay Live menu -->              "
                + "<keypress pressed=\"default\" name=\"incorrect_Selection\">                    "
                + "    <play type=\"tts\" voice=\"female1\" name=\"play_Inorrect_Selection\">That "
                + "        That is not a valid selection. Please try again.                       "
                + "    </play>                                                                    "
                + "    <goto name=\"replay_Live\">Live</goto>                                     "
                + "</keypress>                                                                    "
                + "</menu>                                                                        "
                + "<menu maxDigits=\"1\" timeout=\"3500\" name=\"order_tickets\">                 "
                + "    <play type=\"tts\" voice=\"female1\" name=\"play_order_tickets\">          "
                + "    You will be transferred to Sales representative in a moment. Please wait.  "
                + "    </play>                                                                    "
                + "    <transfer callerid=\"${call.callerid}\" musiconhold=\"blues\" mode=\"ringall\">"
                + "        15551234567                                                            "
                + "    </transfer>                                                                "
                + "</menu>                                                                        "
                + "<play type=\"tts\" voice=\"female1\" name=\"Goodbye\">                         "
                + "    Thank you for taking our survey                                            "
                + "</play>                                                                        "
                + "<goto name=\"Goodbye_Hangup\">Hangup</goto>                                    "
                + "<play type=\"tts\" voice=\"female1\" name=\"Machine\">                         "
                + "Hello ${contact.firstName} ${contact.lastName}.                                "
                + "We are organizing a charity weekend in November.                               "
                + "If you would like to participate, please call 8 5 5, 5 5 5, 5 5 5 5.           "
                + "Thank you.                                                                     "
                + "</play>                                                                        "
                + "<hangup name=\"Hangup\"/>                                                      "
                + "</dialplan>";
    }
}

