import com.callfire.api.client.CallfireClient;
import com.callfire.api.client.api.contacts.model.Contact;
import com.callfire.api.client.api.contacts.model.request.AddContactListItemsRequest;

import java.util.Arrays;

class ApiClientSample {
    public static void main(String[] args) {
        CallfireClient client = new CallfireClient("api login", "api password");
        AddContactListItemsRequest request1 = AddContactListItemsRequest.<String>create()
            .contactListId(123456L)
            .contacts(Arrays.asList("12135678881", "12135678882"))
            .build();
        client.contactListsApi().addListItems(request1);

        // second example shows how to create contact list from existing contacts, what we need is just their ids:
        AddContactListItemsRequest request2 = AddContactListItemsRequest.<Long>create()
            .contactListId(123456L)
            .contacts(Arrays.asList(123L, 456L, 789L))
            .build();
        client.contactListsApi().addListItems(request2);

        // next code sample uses Contact object in CreateContactListRequest request:
        Contact contact = new Contact();
        contact.setFirstName("John");
        contact.setHomePhone("16505044730");
        contact.getProperties().put("age", "30");
        AddContactListItemsRequest request3 = AddContactListItemsRequest.<Contact>create()
            .contactListId(123456L)
            .contacts(Arrays.asList(contact))
            .build();
        client.contactListsApi().addListItems(request3);
    }
}
