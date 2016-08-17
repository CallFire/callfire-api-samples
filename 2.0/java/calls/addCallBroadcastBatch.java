import com.callfire.api.client.CallfireClient;
import com.callfire.api.client.api.campaigns.model.Recipient;
import com.callfire.api.client.api.campaigns.model.request.AddBatchRequest;
import com.callfire.api.client.api.common.model.ResourceId;

import java.util.Arrays;

class ApiClientSample {
    public static void main(String[] args) {
        CallfireClient callfireClient = new CallfireClient("api_login", "api_password");
        Recipient recipient1 = new Recipient();
        recipient1.setPhoneNumber("12131234567");
        Recipient recipient2 = new Recipient();
        recipient2.setPhoneNumber("12131234568");
        AddBatchRequest request = AddBatchRequest.create()
            .campaignId(123456L)
            .name("new_batch")
            .scrubDuplicates(true)
            .recipients(Arrays.asList(recipient1, recipient2))
            .build();
        ResourceId resourceId = callfireClient.callBroadcastsApi().addBatch(request);
    }
}
