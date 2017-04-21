import com.callfire.api.client.CallfireClient;
import com.callfire.api.client.api.common.model.ResourceId;
import com.callfire.api.client.api.contacts.model.Contact;
import com.callfire.api.client.api.contacts.model.request.CreateContactListRequest;

import java.util.Arrays;

class ApiClientSample {
    public static void main(String[] args) {
        CallfireClient client = new CallfireClient("api login", "api password");
        CreateContactListRequest request1 = CreateContactListRequest.<String>create()
            .name("My Contact List")
            .contacts(Arrays.asList("12132212384", "12136612355", "12133312300"))
            .contactNumbersField("workPhone")
            .build();
        ResourceId resourceId1 = client.contactListsApi().create(request1);

        // second example shows how to create contact list from existing contacts, what we need is just their ids:
        CreateContactListRequest request2 = CreateContactListRequest.<Long>create()
            .name("My Contact List")
            .contacts(Arrays.asList(800634185003L, 800734186003L, 800834187003L, 800984185003L))
            .build();
        ResourceId resourceId2 = client.contactListsApi().create(request2);

        // next code sample uses Contact object in CreateContactListRequest request:
        Contact contact1 = new Contact();
        contact1.setFirstName("Alice");
        contact1.setLastName("Moore");
        contact1.setHomePhone("12135551126");

        Contact contact2 = new Contact();
        contact1.setFirstName("Bob");
        contact1.setLastName("Smith");
        contact1.setHomePhone("12135551127");
        contact1.getProperties().put("age", "30");
        CreateContactListRequest request3 = CreateContactListRequest.<Contact>create()
            .name("My Contact List")
            .contacts(Arrays.asList(contact1, contact2))
            .build();
        ResourceId resourceId3 = client.contactListsApi().create(request3);
    }
}
