import com.callfire.api.client.CallfireClient;
import com.callfire.api.client.api.callstexts.model.Text;
import com.callfire.api.client.api.callstexts.model.request.SendTextsRequest;
import com.callfire.api.client.api.campaigns.model.TextRecipient;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class ApiClientSample {
    public static void main(String[] args) {
        CallfireClient client = new CallfireClient("api_login", "api_password");

        TextRecipient r1 = new TextRecipient();
        r1.setPhoneNumber("12135551122");
        r1.setMessage("Hello World!");
        TextRecipient r2 = new TextRecipient();
        r2.setContactId(122460000043L);
        TextRecipient r3 = new TextRecipient();
        r1.setPhoneNumber("12135558090");
        r1.setMessage("Hello World!");
        Map<String,String> attrs = new HashMap<>();
        attrs.put("custom_external_id", "30005044");
        attrs.put("custom_name", "Alice");
        r3.setAttributes(attrs);
        r3.setMessage("Hello, ${custom_name}!");
        List<TextRecipient> recipients = Arrays.asList(r1, r2, r3);

        SendTextsRequest request = SendTextsRequest.create()
            .recipients(recipients)
            .campaignId(4050600003L)
            .defaultMessage("Hello!")
            .build();
        List<Text> texts = client.textsApi().send(request);
    }
}
