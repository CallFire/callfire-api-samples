import com.callfire.api.client.CallfireClient;
import com.callfire.api.client.api.callstexts.model.Text;
import com.callfire.api.client.api.campaigns.model.TextRecipient;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class ApiClientSample {
    public static void main(String[] args) {
        CallfireClient client = new CallfireClient("api_login", "api_password");
        TextRecipient recipient1 = new TextRecipient();
        recipient1.setPhoneNumber("12135551122");
        TextRecipient recipient2 = new TextRecipient();
        recipient2.setContactId(122460000043L);
        TextRecipient recipient3 = new TextRecipient();
        recipient3.setPhoneNumber("12135558090");
        Map<String,String> attrs = new HashMap<>();
        attrs.put("custom_external_id", "30005044");
        attrs.put("custom_property_1", "value1");
        recipient3.setAttributes(attrs);
        List<Text> texts = client.textBroadcastsApi().addRecipients(11646003L, Arrays.asList(recipient1, recipient2, recipient3));
    }
}
