import com.callfire.api.client.CallfireClient;

import java.io.InputStream;

class ApiClientSample {
    public static void main(String[] args) {
        CallfireClient callfireClient = new CallfireClient("api_login", "api_password");
        InputStream is = callfireClient.campaignSoundsApi().getWav(12345L);
    }
}
