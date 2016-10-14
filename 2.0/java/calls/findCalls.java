import com.callfire.api.client.CallfireClient;
import com.callfire.api.client.api.callstexts.model.Call;
import com.callfire.api.client.api.callstexts.model.request.FindCallsRequest;
import com.callfire.api.client.api.common.model.Page;

import java.util.Arrays;

class ApiClientSample {
    public static void main(String[] args) {
        CallfireClient client = new CallfireClient("api_login", "api_password");
        // find all calls made through particular campaign, with exact toNumber and fromNumber
        FindCallsRequest request = FindCallsRequest.create()
            .id(Arrays.asList(617067920003L))
            .campaignId(7373801003L)
            .fromNumber("12132609784")
            .toNumber("12132212384")
            .build();
        Page<Call> calls = client.callsApi().find(request);
        // check Call.records.questionResponses list for stored data
    }
}
