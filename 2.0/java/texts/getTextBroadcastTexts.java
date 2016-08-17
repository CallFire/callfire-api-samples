import com.callfire.api.client.CallfireClient;
import com.callfire.api.client.api.callstexts.model.Text;
import com.callfire.api.client.api.campaigns.model.request.FindBroadcastTextsRequest;
import com.callfire.api.client.api.common.model.Page;

class ApiClientSample {
    public static void main(String[] args) {
        CallfireClient client = new CallfireClient("api_login", "api_password");
        FindBroadcastTextsRequest request = FindBroadcastTextsRequest.create()
            .id(1234L)
            .build();
        Page<Text> texts = client.textBroadcastsApi().findTexts(request);
    }
}
