import com.callfire.api.client.CallfireClient;
import com.callfire.api.client.api.campaigns.model.CallBroadcast;
import com.callfire.api.client.api.campaigns.model.request.FindCallBroadcastsRequest;
import com.callfire.api.client.api.common.model.Page;

class ApiClientSample {
    public static void main(String[] args) {
        CallfireClient client = new CallfireClient("api_login", "api_password");
        FindCallBroadcastsRequest request = FindCallBroadcastsRequest.create()
            // find all call broadcasts which name like 'campaign'
            .name("broadcast name")
            .label("my label")
            .running(true)
            .offset(0L)
            .limit(2L)
            .fields("items(id,name,status,sounds)")
            .build();
        Page<CallBroadcast> broadcasts = client.callBroadcastsApi().find(request);
    }
}
