import com.callfire.api.client.CallfireClient;
import com.callfire.api.client.api.webhooks.model.Webhook;

class ApiClientSample {
    public static void main(String[] args) {
        CallfireClient client = new CallfireClient("api login", "api password");
        Webhook webhook = client.webhooksApi().get(379506003L, "name,callback");
    }
}
