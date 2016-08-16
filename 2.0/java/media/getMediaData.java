import com.callfire.api.client.CallfireClient;
import com.callfire.api.client.api.callstexts.model.MediaType;

import java.io.InputStream;

class ApiClientSample {
    public static void main(String[] args) {
        CallfireClient client = new CallfireClient("api_login", "api_password");
        InputStream is1 = client.mediaApi().getData(617067920003L, MediaType.MP3);
        // or you can get file by hash
        InputStream is2 = client.mediaApi().getData("450cffe3c128377a790df0059fb82fd6", MediaType.GIF);
    }
}
