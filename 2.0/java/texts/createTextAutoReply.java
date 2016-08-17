import com.callfire.api.client.CallfireClient;
import com.callfire.api.client.api.campaigns.model.TextAutoReply;
import com.callfire.api.client.api.common.model.ResourceId;

class ApiClientSample {
    public static void main(String[] args) {
        CallfireClient client = new CallfireClient("api_login", "api_password");
        TextAutoReply textAutoReply = new TextAutoReply();
        textAutoReply.setNumber("12132226464");
        textAutoReply.setMessage("test message");
        textAutoReply.setMatch("vacation");
        ResourceId resourceId = client.textAutoRepliesApi().create(textAutoReply);
    }
}
