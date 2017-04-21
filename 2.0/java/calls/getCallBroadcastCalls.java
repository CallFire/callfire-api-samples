import com.callfire.api.client.CallfireClient;
import com.callfire.api.client.api.callstexts.model.Call;
import com.callfire.api.client.api.campaigns.model.request.FindBroadcastCallsRequest;
import com.callfire.api.client.api.common.model.Page;

class ApiClientSample {
    public static void main(String[] args) {
        CallfireClient client = new CallfireClient("api_login", "api_password");
        FindBroadcastCallsRequest request = FindBroadcastCallsRequest.create()
            .id(11646003L)
            .batchId(5500030002L)
            .offset(0L)
            .limit(10L)
            .fields("items(fromNumber,toNumber,state,modified)")
        .build();
        Page<Call> calls = client.callBroadcastsApi().findCalls(request);
    }
}
