import com.callfire.api.client.CallfireClient;
import com.callfire.api.client.api.webhooks.model.Webhook;

class ApiClientSample {
    public static void main(String[] args) {
        CallfireClient client = new CallfireClient("api login", "api password");
        Webhook webhook = client.webhooksApi().get(12345678L, "id,name,created");
    }
}
