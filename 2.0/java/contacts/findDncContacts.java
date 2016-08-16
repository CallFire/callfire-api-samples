import com.callfire.api.client.CallfireClient;
import com.callfire.api.client.api.common.model.Page;
import com.callfire.api.client.api.contacts.model.DoNotContact;
import com.callfire.api.client.api.contacts.model.request.FindDncContactsRequest;

class ApiClientSample {
    public static void main(String[] args) {
        CallfireClient client = new CallfireClient("api login", "api password");
        FindDncContactsRequest request = FindDncContactsRequest.create().build();
        Page<DoNotContact> doNotContactList = client.dncApi().find(request);
    }
}
