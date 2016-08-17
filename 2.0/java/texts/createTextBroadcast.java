import com.callfire.api.client.CallfireClient;
import com.callfire.api.client.api.campaigns.model.LocalTimeRestriction;
import com.callfire.api.client.api.campaigns.model.TextBroadcast;
import com.callfire.api.client.api.campaigns.model.TextRecipient;
import com.callfire.api.client.api.common.model.ResourceId;

import java.util.Arrays;

class ApiClientSample {
    public static void main(String[] args) {
        CallfireClient client = new CallfireClient("api_login", "api_password");

        TextBroadcast broadcast = new TextBroadcast();
        broadcast.setName("broadcast");
        broadcast.setFromNumber("12131234567");
        // time restrictions
        LocalTimeRestriction restrictions = new LocalTimeRestriction();
        restrictions.setBeginHour(10);
        restrictions.setBeginMinute(10);
        restrictions.setEndHour(22);
        restrictions.setEndMinute(0);
        restrictions.setEnabled(true);
        // create recipients
        TextRecipient recipient1 = new TextRecipient();
        recipient1.setPhoneNumber("12131234567");
        TextRecipient recipient2 = new TextRecipient();
        recipient2.setPhoneNumber("12131234568");
        broadcast.setRecipients(Arrays.asList(recipient1, recipient2));
        broadcast.setLocalTimeRestriction(restrictions);
        broadcast.setBigMessageStrategy(TextBroadcast.BigMessageStrategy.SEND_MULTIPLE);
        broadcast.setMessage("test_msg");
        broadcast.setResumeNextDay(true);
        // create broadcast
        ResourceId id = client.textBroadcastsApi().create(broadcast, true);
    }
}
