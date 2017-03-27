import java.util.Arrays;
import java.util.List;

import com.callfire.api.client.CallfireClient;
import com.callfire.api.client.api.callstexts.model.Text;
import com.callfire.api.client.api.campaigns.model.TextRecipient;

class ApiClientSample {
    public static void main(String[] args) {
        CallfireClient client = new CallfireClient("api_login", "api_password");

        TextRecipient r1 = new TextRecipient();
        r1.setPhoneNumber("12135551100");
        r1.setMessage("Hey there");
        // Set custom attribute
        r1.getAttributes().put("external_user_id", "45450007002");

        List<TextRecipient> recipients = Arrays.asList(r1);
        List<Text> texts = client.textsApi().send(recipients);
    }
}
