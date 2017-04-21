import com.callfire.api.client.CallfireClient;
import com.callfire.api.client.api.common.model.Page;
import com.callfire.api.client.api.contacts.model.ContactList;
import com.callfire.api.client.api.contacts.model.request.FindContactListsRequest;

class ApiClientSample {
    public static void main(String[] args) {
        CallfireClient client = new CallfireClient("api login", "api password");
        FindContactListsRequest request = FindContactListsRequest.create()
            .name("my list")
            .offset(0L)
            .limit(10L)
            .fields("items(id,name,size)")
            .build();
        Page<ContactList> contactLists = client.contactListsApi().find(request);
    }
}
