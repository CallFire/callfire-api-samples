import com.callfire.api.client.CallfireClient;

import java.io.InputStream;

class ApiClientSample {
    public static void main(String[] args) {
        CallfireClient client = new CallfireClient("api_login", "api_password");
        InputStream is = client.callsApi().getCallRecordingMp3ByName(1234L, "testName");
    }
}
