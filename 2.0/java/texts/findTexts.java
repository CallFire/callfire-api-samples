import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;

import com.callfire.api.client.CallfireClient;
import com.callfire.api.client.api.callstexts.model.Text;
import com.callfire.api.client.api.callstexts.model.request.FindTextsRequest;
import com.callfire.api.client.api.common.model.Page;
import static com.callfire.api.client.api.callstexts.model.Action.State;
import static com.callfire.api.client.api.callstexts.model.TextRecord.TextResult;

class ApiClientSample {
    public static void main(String[] args) throws ParseException {
        CallfireClient client = new CallfireClient("api_login", "api_password");
        FindTextsRequest request = FindTextsRequest.create()
            .id(Arrays.asList(11646003L, 12646003L, 13776003L))
            .campaignId(449060003L)
            .batchId(447060003L)
            .fromNumber("12135551126")
            .toNumber("12136666123")
            .label("my label")
            .states(Arrays.asList(State.READY, State.FINISHED, State.INVALID))
            .results(Arrays.asList(TextResult.RECEIVED))
            .inbound(true)
            .intervalBegin(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse("2016-09-13 15:50:17"))
            .intervalEnd(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse("2016-09-13 15:50:17"))
            .offset(0L)
            .limit(10L)
            .fields("items(id,fromNumber,toNumber,modified,message)")
            .build();
        Page<Text> texts = client.textsApi().find(request);
    }
}

