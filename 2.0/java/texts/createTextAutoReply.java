import com.callfire.api.client.CallfireClient;
import com.callfire.api.client.api.campaigns.model.TextAutoReply;
import com.callfire.api.client.api.common.model.ResourceId;

class ApiClientSample {
    public static void main(String[] args) {
        CallfireClient client = new CallfireClient("api_login", "api_password");
        TextAutoReply textAutoReply = new TextAutoReply();
        textAutoReply.setNumber("67076");
        textAutoReply.setMessage("I am a leaf on the wind");
        textAutoReply.setKeyword("CALLFIRE");
        ResourceId resourceId = client.textAutoRepliesApi().create(textAutoReply);
    }
}
