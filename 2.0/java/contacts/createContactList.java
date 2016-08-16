import com.callfire.api.client.CallfireClient;
import com.callfire.api.client.api.common.model.ResourceId;
import com.callfire.api.client.api.contacts.model.Contact;
import com.callfire.api.client.api.contacts.model.request.CreateContactListRequest;

import java.util.Arrays;

class ApiClientSample {
    public static void main(String[] args) {
        CallfireClient client = new CallfireClient("api login", "api password");
        CreateContactListRequest request1 = CreateContactListRequest.<String>create()
            .name("listFromNumbers")
            .contacts(Arrays.asList("12135678881", "12135678882"))
            .build();
        ResourceId resourceId1 = client.contactListsApi().create(request1);

        // second example shows how to create contact list from existing contacts, what we need is just their ids:
        CreateContactListRequest request2 = CreateContactListRequest.<Long>create()
            .name("listFromExistingContacts")
            .contacts(Arrays.asList(123L, 456L, 789L))
            .build();
        ResourceId resourceId2 = client.contactListsApi().create(request2);

        // next code sample uses Contact object in CreateContactListRequest request:
        Contact contact = new Contact();
        contact.setFirstName("John");
        contact.setHomePhone("16505044730");
        contact.getProperties().put("age", "30");
        CreateContactListRequest request3 = CreateContactListRequest.<Contact>create()
            .name("listFromContacts")
            .contacts(Arrays.asList(contact))
            .build();
        ResourceId resourceId3 = client.contactListsApi().create(request3);
    }
}
