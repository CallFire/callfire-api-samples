import com.callfire.api.client.CallfireClient;
import com.callfire.api.client.api.campaigns.model.TextBroadcast;
import com.callfire.api.client.api.campaigns.model.request.FindTextBroadcastsRequest;
import com.callfire.api.client.api.common.model.Page;

class ApiClientSample {
    public static void main(String[] args) {
        CallfireClient client = new CallfireClient("api_login", "api_password");
        FindTextBroadcastsRequest request = FindTextBroadcastsRequest.create()
            .name("campaign")
            .limit(2L)
            .build();
        Page<TextBroadcast> broadcasts = client.textBroadcastsApi().find(request);
    }
}
