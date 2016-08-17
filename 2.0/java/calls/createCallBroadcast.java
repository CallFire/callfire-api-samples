import com.callfire.api.client.CallfireClient;
import com.callfire.api.client.api.campaigns.model.AnsweringMachineConfig;
import com.callfire.api.client.api.campaigns.model.CallBroadcast;
import com.callfire.api.client.api.campaigns.model.CallBroadcastSounds;
import com.callfire.api.client.api.campaigns.model.Recipient;
import com.callfire.api.client.api.campaigns.model.Voice;
import com.callfire.api.client.api.common.model.ResourceId;

import java.util.Arrays;

class ApiClientSample {
    public static void main(String[] args) {
        CallfireClient callfireClient = new CallfireClient("api_login", "api_password");
        CallBroadcast broadcast = new CallBroadcast();
        broadcast.setName("Example VB");
        broadcast.setFromNumber("12135551189");
        broadcast.setAnsweringMachineConfig(AnsweringMachineConfig.AM_AND_LIVE);
        CallBroadcastSounds sounds = new CallBroadcastSounds();
        sounds.setLiveSoundTextVoice(Voice.MALE1);
        sounds.setLiveSoundText("Hello! This is a live answer text to speech recording");
        sounds.setMachineSoundText("This is an answering machine text to speech recording");
        sounds.setMachineSoundTextVoice(Voice.MALE1);
        broadcast.setSounds(sounds);
        broadcast.setResumeNextDay(true);
        // set recipients
        Recipient recipient1 = new Recipient();
        recipient1.setPhoneNumber("12135551100");
        Recipient recipient2 = new Recipient();
        recipient2.setPhoneNumber("12135551101");
        broadcast.setRecipients(Arrays.asList(recipient1, recipient2));
        // create broadcast with 'start' argument = true to start campaign immediately
        ResourceId id = callfireClient.callBroadcastsApi().create(broadcast, true);
    }
}
