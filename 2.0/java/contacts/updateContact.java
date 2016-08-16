import com.callfire.api.client.CallfireClient;
import com.callfire.api.client.api.contacts.model.Contact;

class ApiClientSample {
    public static void main(String[] args) {
        CallfireClient client = new CallfireClient("api login", "api password");
        Contact contact = new Contact();
        contact.setId(463633187003L);
        contact.setHomePhone("16505044730");
        client.contactsApi().update(contact);
    }
}
