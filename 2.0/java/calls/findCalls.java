import com.callfire.api.client.CallfireClient;
import com.callfire.api.client.api.callstexts.model.Call;
import com.callfire.api.client.api.callstexts.model.request.FindCallsRequest;
import com.callfire.api.client.api.common.model.Page;
import static com.callfire.api.client.api.callstexts.model.Action.State;
import static com.callfire.api.client.api.callstexts.model.Call.CallResult;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;

class ApiClientSample {
    public static void main(String[] args) throws ParseException {
        CallfireClient client = new CallfireClient("api_login", "api_password");
        // find all calls made through particular campaign, with exact toNumber and fromNumber
        FindCallsRequest request = FindCallsRequest.create()
            .id(Arrays.asList(11646003L, 12646003L, 13776003L))
            .campaignId(449060003L)
            .batchId(447060003L)
            .fromNumber("12135551126")
            .toNumber("12136666123")
            .label("my label")
            .states(Arrays.asList(State.READY, State.FINISHED, State.INVALID))
            .results(Arrays.asList(CallResult.LA))
            .inbound(false)
            .intervalBegin(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse("2016-09-13 15:50:17"))
            .intervalEnd(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse("2016-09-13 15:50:17"))
            .offset(0L)
            .limit(10L)
            .fields("items(id,fromNumber,toNumber,modified,finalCallResult)")
            .build();
        Page<Call> calls = client.callsApi().find(request);
        // check Call.records.questionResponses list for stored data
    }
}

