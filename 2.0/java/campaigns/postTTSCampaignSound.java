import com.callfire.api.client.CallfireClient;
import com.callfire.api.client.api.campaigns.model.TextToSpeech;
import com.callfire.api.client.api.campaigns.model.Voice;
import com.callfire.api.client.api.common.model.ResourceId;

class ApiClientSample {
    public static void main(String[] args) {
        CallfireClient callfireClient = new CallfireClient("api_login", "api_password");
        TextToSpeech tts = new TextToSpeech();
        tts.setVoice(Voice.FEMALE1);
        tts.setMessage("this is TTS message from java client");
        ResourceId resourceId = callfireClient.campaignSoundsApi().createFromTts(tts);
    }
}
