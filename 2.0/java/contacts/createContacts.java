import com.callfire.api.client.CallfireClient;
import com.callfire.api.client.api.common.model.ResourceId;
import com.callfire.api.client.api.contacts.model.Contact;

import java.util.Arrays;
import java.util.List;

class ApiClientSample {
    public static void main(String[] args) {
        CallfireClient client = new CallfireClient("api login", "api password");
        Contact contact = new Contact();
        contact.setFirstName("John");
        contact.setLastName("Doe");
        contact.setHomePhone("16505044730");
        contact.getProperties().put("age", "30");
        contact.getProperties().put("customField", "customValue");
        List<Contact> inputContacts = Arrays.asList(contact);
        List<ResourceId> resultResourceIds = client.contactsApi().create(inputContacts);
    }
}
