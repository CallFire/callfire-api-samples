import com.callfire.api.client.CallfireClient;
import com.callfire.api.client.api.campaigns.model.TextAutoReply;
import com.callfire.api.client.api.campaigns.model.request.FindTextAutoRepliesRequest;
import com.callfire.api.client.api.common.model.Page;

class ApiClientSample {
    public static void main(String[] args) {
        CallfireClient client = new CallfireClient("api_login", "api_password");
        FindTextAutoRepliesRequest request = FindTextAutoRepliesRequest.create()
            .number("12132226464")
            .build();
        Page<TextAutoReply> textAutoReplies = client.textAutoRepliesApi().find(request);
    }
}
