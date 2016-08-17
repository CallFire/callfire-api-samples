import com.callfire.api.client.CallfireClient;
import com.callfire.api.client.api.callstexts.model.Call;
import com.callfire.api.client.api.campaigns.model.request.FindBroadcastCallsRequest;
import com.callfire.api.client.api.common.model.Page;

class ApiClientSample {
    public static void main(String[] args) {
        CallfireClient client = new CallfireClient("api_login", "api_password");
        FindBroadcastCallsRequest request = FindBroadcastCallsRequest.create()
            .id(1234L)
            .build();
        Page<Call> calls = client.callBroadcastsApi().findCalls(request);
    }
}
