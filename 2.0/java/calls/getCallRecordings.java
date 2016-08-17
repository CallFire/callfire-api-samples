import com.callfire.api.client.CallfireClient;
import com.callfire.api.client.api.campaigns.model.CallRecording;

import java.util.List;

class ApiClientSample {
    public static void main(String[] args) {
        CallfireClient client = new CallfireClient("api_login", "api_password");
        List<CallRecording> recs = client.callsApi().getCallRecordings(1232L, "items(callId)");
    }
}
