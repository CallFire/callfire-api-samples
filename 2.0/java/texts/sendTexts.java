import com.callfire.api.client.CallfireClient;
import com.callfire.api.client.api.callstexts.model.Text;
import com.callfire.api.client.api.campaigns.model.TextRecipient;

import java.util.Arrays;
import java.util.List;

class ApiClientSample {
    public static void main(String[] args) {
        CallfireClient client = new CallfireClient("api_login", "api_password");

        TextRecipient r1 = new TextRecipient();
        r1.setPhoneNumber("16502572135");
        r1.setMessage("Hello 1");
        TextRecipient r2 = new TextRecipient();
        r2.setPhoneNumber("16502572008");
        r2.setMessage("Hello 2");
        List<TextRecipient> recipients = Arrays.asList(r1, r2);
        List<Text> texts = client.textsApi().send(recipients);

        // in case you have multiple recipients with the same text you can use defaultMessage param to specify 
        // text once for all recipients
        // SendTextsRequest request = SendTextsRequest.create()
        //    .recipients(recipients)
        // limit returned fields if needed
        //    .fields("items(id,fromNumber,state)")
        //    .defaultMessage("defaultMessage")
        //    .build();
        //List<Text> texts = client.textsApi().send(request);
    }
}
