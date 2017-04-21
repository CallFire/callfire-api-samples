import com.callfire.api.client.CallfireClient;
import com.callfire.api.client.api.callstexts.model.Media;

class ApiClientSample {
    public static void main(String[] args) {
        CallfireClient client = new CallfireClient("api_login", "api_password");
        // you can limit what fields will be returned in second argument
        Media media = client.mediaApi().get(379506003L, "name,publicUrl");
    }
}
