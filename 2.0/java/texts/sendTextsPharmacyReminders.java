import com.callfire.api.client.CallfireClient;
import com.callfire.api.client.api.callstexts.model.Text;
import com.callfire.api.client.api.campaigns.model.TextRecipient;

import java.util.Arrays;
import java.util.List;

class ApiClientSample {
    public static void main(String[] args) {
        CallfireClient client = new CallfireClient("api_login", "api_password");

        TextRecipient recipient = new TextRecipient();
        recipient.setPhoneNumber("12135551123");
        recipient.setMessage("Hello ${contact_name}, you have an appointment with Dr. Andrew "
            + "tomorrow at 3:00 PM, if you need to reschedule please call (855)-555-4477");
        // Set custom attribute
        recipient.getAttributes().put("external_user_id", "45450007002");
        recipient.getAttributes().put("contact_name":"Alice");

        List<TextRecipient> recipients = Arrays.asList(recipient);
        List<Text> texts = client.textsApi().send(recipients);
    }
}
