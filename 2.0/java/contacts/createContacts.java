import com.callfire.api.client.CallfireClient;
import com.callfire.api.client.api.common.model.ResourceId;
import com.callfire.api.client.api.contacts.model.Contact;

import java.util.Arrays;
import java.util.List;

class ApiClientSample {
    public static void main(String[] args) {
        CallfireClient client = new CallfireClient("api login", "api password");
        Contact contact1 = new Contact();
        contact1.setFirstName("Alice");
        contact1.setLastName("Moore");
        contact1.setHomePhone("12135551126");
        contact1.setMobilePhone("12136666123");
        contact1.setWorkPhone("14553327789");
        contact1.setZipcode("40460");
        contact1.getProperties().put("custom_ext_system_id", "100200301");

        Contact contact2 = new Contact();
        contact2.setFirstName("Bob");
        contact2.setLastName("Smith");
        contact2.setHomePhone("12135551127");
        contact2.getProperties().put("age", "30");
        contact2.getProperties().put("custom_position", "Manager");
        List<Contact> inputContacts = Arrays.asList(contact1, contact2);
        List<ResourceId> resultResourceIds = client.contactsApi().create(inputContacts);
    }
}
