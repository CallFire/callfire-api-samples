import com.callfire.api.client.CallfireClient;
import com.callfire.api.client.api.contacts.model.request.UpdateContactListRequest;

class ApiClientSample {
    public static void main(String[] args) {
        CallfireClient client = new CallfireClient("api login", "api password");
        UpdateContactListRequest request = UpdateContactListRequest.create()
            .id(1026694003L)
            .name("sampleListName").
                build();
        client.contactListsApi().update(request);
    }
}
