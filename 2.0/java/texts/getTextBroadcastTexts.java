import com.callfire.api.client.CallfireClient;
import com.callfire.api.client.api.callstexts.model.Text;
import com.callfire.api.client.api.campaigns.model.request.FindBroadcastTextsRequest;
import com.callfire.api.client.api.common.model.Page;

class ApiClientSample {
    public static void main(String[] args) {
        CallfireClient client = new CallfireClient("api_login", "api_password");
        FindBroadcastTextsRequest request = FindBroadcastTextsRequest.create()
            .id(5500030002L)
            .offset(0L)
            .limit(10L)
            .fields("items(fromNumber,toNumber,state,message)")
            .build();
        Page<Text> texts = client.textBroadcastsApi().findTexts(request);
    }
}
