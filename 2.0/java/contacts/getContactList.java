import com.callfire.api.client.CallfireClient;
import com.callfire.api.client.api.contacts.model.ContactList;

class ApiClientSample {
    public static void main(String[] args) {
        CallfireClient client = new CallfireClient("api login", "api password");
        ContactList contactList = client.contactListsApi().get(1026694003L);
    }
}
