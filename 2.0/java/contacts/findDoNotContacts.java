import com.callfire.api.client.CallfireClient;
import com.callfire.api.client.api.common.model.Page;
import com.callfire.api.client.api.contacts.model.DoNotContact;
import com.callfire.api.client.api.contacts.model.request.FindDncNumbersRequest;


class ApiClientSample {
    public static void main(String[] args) {
        CallfireClient client = new CallfireClient("api login", "api password");
        FindDncNumbersRequest request = FindDncNumbersRequest.create()
            // search only Do-Not-Text numbers
            .text(true)
            // search numbers starting 1-(424)
            .prefix("1424")
            // limit response to 10 entries
            .limit(10L)
            .build();
        Page<DoNotContact> dncContacts = client.dncApi().find(request);
    }
}
