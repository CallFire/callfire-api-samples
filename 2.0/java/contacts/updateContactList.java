import com.callfire.api.client.CallfireClient;
import com.callfire.api.client.api.contacts.model.request.UpdateContactListRequest;

class ApiClientSample {
    public static void main(String[] args) {
        CallfireClient client = new CallfireClient("api login", "api password");
        UpdateContactListRequest request = UpdateContactListRequest.create()
            .id(11646003L)
            .name("contact list updated")
            .build();
        client.contactListsApi().update(request);
    }
}
