import com.callfire.api.client.CallfireClient;
import com.callfire.api.client.api.callstexts.model.Text;
import com.callfire.api.client.api.campaigns.model.TextRecipient;

import java.util.Arrays;
import java.util.List;

class ApiClientSample {
    public static void main(String[] args) {
        CallfireClient client = new CallfireClient("api_login", "api_password");
        TextRecipient recipient1 = new TextRecipient();
        recipient1.setPhoneNumber("12131234567");
        TextRecipient recipient2 = new TextRecipient();
        recipient2.setPhoneNumber("12131234568");
        List<Text> texts = client.textBroadcastsApi().addRecipients(123456L, Arrays.asList(recipient1, recipient2));
    }
}
