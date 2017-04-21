import com.callfire.api.client.CallfireClient;
import com.callfire.api.client.api.callstexts.model.MediaType;

import java.io.InputStream;

class ApiClientSample {
    public static void main(String[] args) {
        CallfireClient client = new CallfireClient("api_login", "api_password");
        InputStream is = client.mediaApi().getData("f733daab-fc05-470d-abe6-87cd136599ad", MediaType.MP3);
    }
}
