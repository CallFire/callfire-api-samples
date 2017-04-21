import com.callfire.api.client.CallfireClient;
import com.callfire.api.client.api.campaigns.model.CallRecording;

class ApiClientSample {
    public static void main(String[] args) {
        CallfireClient client = new CallfireClient("api_login", "api_password");
        CallRecording recording = client.callsApi().getCallRecordingByName(379506003L, "call-recording1", "callId,campaignId,lengthInBytes,mp3Url");
    }
}
