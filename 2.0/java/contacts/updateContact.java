import com.callfire.api.client.CallfireClient;
import com.callfire.api.client.api.contacts.model.Contact;

class ApiClientSample {
    public static void main(String[] args) {
        CallfireClient client = new CallfireClient("api login", "api password");
        Contact contact = new Contact();
        contact.setId(11646003L);
        contact.setMobilePhone("12136600123");
        contact.setWorkPhone("14553320089");
        client.contactsApi().update(contact);
    }
}

