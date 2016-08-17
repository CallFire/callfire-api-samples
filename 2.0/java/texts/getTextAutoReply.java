import com.callfire.api.client.CallfireClient;
import com.callfire.api.client.api.campaigns.model.TextAutoReply;

class ApiClientSample {
    public static void main(String[] args) {
        CallfireClient client = new CallfireClient("api_login", "api_password");
        TextAutoReply textAutoReply = client.textAutoRepliesApi().get(12345L);
    }
}
