import com.callfire.api.client.CallfireClient;
import com.callfire.api.client.api.campaigns.model.AnsweringMachineConfig;
import com.callfire.api.client.api.campaigns.model.CallBroadcast;
import com.callfire.api.client.api.campaigns.model.CallBroadcastSounds;
import com.callfire.api.client.api.campaigns.model.Recipient;
import com.callfire.api.client.api.common.model.ResourceId;

import java.time.DayOfWeek;
import java.util.Arrays;
import java.util.HashSet;

/**
 * Example shows how to schedule a voice broadcast in a single call
 * and send a voice message to 3 recipients
 */
class ApiClientSample {

    public static void main(String[] args) {
        CallfireClient client = new CallfireClient("api_login", "api_password");
        CallBroadcast broadcast = new CallBroadcast();
        broadcast.setName("Example API Call Broadcast");
        // set validated Caller ID number.
        broadcast.setFromNumber("12135551189");
        // set answering machine detection
        broadcast.setAnsweringMachineConfig(AnsweringMachineConfig.AM_AND_LIVE);

        // set voice messages using TTS option for Live answers and when Answering Machine is detected.
        CallBroadcastSounds sounds = new CallBroadcastSounds();
        sounds.setLiveSoundText("Hello! This is a live answer text to speech recording");
        sounds.setMachineSoundText("This is an answering machine text to speech recording");
        broadcast.setSounds(sounds);

        // add new recipients
        Recipient recipient1 = new Recipient();
        recipient1.setPhoneNumber("2134441133");

        Recipient recipient2 = new Recipient();
        recipient2.setPhoneNumber("2135551144");

        broadcast.setRecipients(Arrays.asList(recipient1, recipient2));

        broadcast.setResumeNextDay(true);

        // create broadcast with 'start' argument = true to start campaign immediately
        ResourceId id = client.callBroadcastsApi().create(broadcast, false);

        System.out.println(id);
    }
}
