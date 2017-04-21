import com.callfire.api.client.CallfireClient;
import com.callfire.api.client.api.callstexts.model.CallRecipient;
import com.callfire.api.client.api.campaigns.model.request.AddBatchRequest;
import com.callfire.api.client.api.common.model.ResourceId;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class ApiClientSample {
    public static void main(String[] args) {
        CallfireClient callfireClient = new CallfireClient("api_login", "api_password");
        CallRecipient recipient1 = new CallRecipient();
        recipient1.setPhoneNumber("12135551122");
        CallRecipient recipient2 = new CallRecipient();
        recipient2.setPhoneNumber("12135553434");
        CallRecipient recipient3 = new CallRecipient();
        recipient3.setPhoneNumber("12135558090");
        Map<String,String> attrs = new HashMap<>();
        attrs.put("custom_external_id", "30005044");
        attrs.put("custom_property_1", "value1");
        recipient3.setAttributes(attrs);

        AddBatchRequest request = AddBatchRequest.create()
            .campaignId(11646003L)
            .name("contact batch for call broadcast")
            .scrubDuplicates(true)
            .recipients(Arrays.asList(recipient1, recipient2, recipient3))
            //or you can add contacts from particular contact list
            //.contactListId(70055003L)
            .build();
        ResourceId resourceId = callfireClient.callBroadcastsApi().addBatch(request);
    }
}
