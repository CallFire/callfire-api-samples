import com.callfire.api.client.CallfireClient;
import com.callfire.api.client.api.campaigns.model.CallBroadcast;
import com.callfire.api.client.api.campaigns.model.request.FindCallBroadcastsRequest;
import com.callfire.api.client.api.common.model.Page;

class ApiClientSample {
    public static void main(String[] args) {
        CallfireClient client = new CallfireClient("api_login", "api_password");
        FindCallBroadcastsRequest request = FindCallBroadcastsRequest.create()
            // find all call broadcasts which name like 'campaign'
            .name("campaign")
            .limit(2L)
            .build();
        Page<CallBroadcast> broadcasts = client.callBroadcastsApi().find(request);
    }
}
