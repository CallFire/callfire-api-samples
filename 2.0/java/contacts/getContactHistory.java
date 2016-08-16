import com.callfire.api.client.CallfireClient;
import com.callfire.api.client.api.common.model.request.GetByIdRequest;
import com.callfire.api.client.api.contacts.model.ContactHistory;

class ApiClientSample {
    public static void main(String[] args) {
        CallfireClient client = new CallfireClient("api login", "api password");
        ContactHistory history = client.contactsApi().getHistory(GetByIdRequest.create().id(123456L).build());
    }
}
