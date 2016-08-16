import com.callfire.api.client.CallfireClient;
import com.callfire.api.client.api.common.model.Page;
import com.callfire.api.client.api.contacts.model.ContactList;
import com.callfire.api.client.api.contacts.model.request.FindContactListsRequest;

class ApiClientSample {
    public static void main(String[] args) {
        CallfireClient client = new CallfireClient("api login", "api password");
        FindContactListsRequest request = FindContactListsRequest.create()
            .limit(1L)
            .offset(1L)
            .name("listName")
            .build();
        Page<ContactList> contactLists = client.contactListsApi().find(request);
    }
}
