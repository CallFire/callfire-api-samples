import com.callfire.api.client.CallfireClient;
import com.callfire.api.client.api.callstexts.model.Text;
import com.callfire.api.client.api.callstexts.model.request.FindTextsRequest;
import com.callfire.api.client.api.common.model.Page;

import java.util.Arrays;

class ApiClientSample {
    public static void main(String[] args) {
        CallfireClient client = new CallfireClient("api_login", "api_password");
        FindTextsRequest request = FindTextsRequest.create()
            .id(Arrays.asList(600537356003L))
            .campaignId(7415225003L)
            .fromNumber("16502572135")
            .toNumber("16505044730")
            .build();
        Page<Text> texts = client.textsApi().find(request);
    }
}
