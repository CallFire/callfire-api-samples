import com.callfire.api.client.CallfireClient;
import com.callfire.api.client.api.campaigns.model.request.AddBatchRequest;
import com.callfire.api.client.api.common.model.ResourceId;

class ApiClientSample {
    public static void main(String[] args) {
        CallfireClient callfireClient = new CallfireClient("api_login", "api_password");
        AddBatchRequest request = AddBatchRequest.create()
            .campaignId(11646003L)
            .name("Contacts Batch 1")
            // scrub duplicate numbers if any
            .scrubDuplicates(true)
            // add all contacts from previously created contact list
            .contactListId(300555001L)
            .build();
        ResourceId resourceId = callfireClient.callBroadcastsApi().addBatch(request);
    }
}
