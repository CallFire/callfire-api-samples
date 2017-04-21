import com.callfire.api.client.CallfireClient;
import com.callfire.api.client.api.campaigns.model.CallRecording;

class ApiClientSample {
    public static void main(String[] args) {
        CallfireClient client = new CallfireClient("api_login", "api_password");
        CallRecording rec = client.callsApi().getCallRecording(379506003L, "callId,campaignId,lengthInBytes,mp3Url");
    }
}
