
import com.callfire.api.client.CallfireClient;
import com.callfire.api.client.api.campaigns.model.TextBroadcast;
import com.callfire.api.client.api.campaigns.model.TextRecipient;
import com.callfire.api.client.api.common.model.ResourceId;

import java.util.Arrays;

class ApiClientSample {
    public static void main(String[] args) {
        CallfireClient client = new CallfireClient("api_login", "api_password");

        TextBroadcast broadcast = new TextBroadcast();
        broadcast.setName("Charity SMS Campaign");
        // attach custom labels if needed
        broadcast.setLabels(Arrays.asList("charity", "id-10003"));
        // You can use default shared short code 67076 or uncomment the next line and set your own number
        broadcast.setFromNumber("19206596476");

        // by default if text exceeds length of 160 characters, CallFire will send a text as multiple messages.
        // broadcast.setBigMessageStrategy(TextBroadcast.BigMessageStrategy.TRIM);
        broadcast.setMessage("Hello {u_name} ...");

        // add new recipients
        TextRecipient recipient1 = new TextRecipient();
        recipient1.setPhoneNumber("13233834422");
        // set custom recipient attributes, they are available only to a single Call/Text
        //  action, do not confuse them with contact fields which are stored with contact and are available to
        //  each Call/Text where contact is attached to
        recipient1.getAttributes().put("u_name", "Alice");
        recipient1.getAttributes().put("age", "30");

        TextRecipient recipient2 = new TextRecipient();
        recipient2.setPhoneNumber("13233834433");
        recipient2.getAttributes().put("u_name", "Mark");
        recipient2.getAttributes().put("age", "45");

        TextRecipient recipient3 = new TextRecipient();
        recipient3.setPhoneNumber("13233834488");
        // You can override a message set in broadcast for a particular recipient
        recipient3.setMessage("Hi {u_name}, the megic number is ${magic_number}");
        // Set custom attribute
        recipient3.getAttributes().put("u_name", "Jane");
        recipient3.getAttributes().put("magic_number", "10");

        broadcast.setRecipients(Arrays.asList(recipient1, recipient2, recipient3));

        // create broadcast and start immediately
        ResourceId id = client.textBroadcastsApi().create(broadcast, true);
    }
}
