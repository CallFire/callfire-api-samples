import com.callfire.api.client.CallfireClient;
import com.callfire.api.client.api.contacts.model.Contact;
import com.callfire.api.client.api.contacts.model.request.AddContactListItemsRequest;

import java.util.Arrays;

class ApiClientSample {
    public static void main(String[] args) {
        CallfireClient client = new CallfireClient("api login", "api password");

        Contact contact1 = new Contact();
        contact1.setFirstName("Alice");
        contact1.setLastName("Moore");
        contact1.setHomePhone("12135551126");

        Contact contact2 = new Contact();
        contact1.setFirstName("Bob");
        contact1.setLastName("Smith");
        contact1.setHomePhone("12135551127");
        contact1.getProperties().put("age", "30");

        AddContactListItemsRequest request1 = AddContactListItemsRequest.<Contact>create()
            .contactListId(45006708003L)
            .contacts(Arrays.asList(contact1, contact2))
            .build();
        client.contactListsApi().addListItems(request1);

        AddContactListItemsRequest request2 = AddContactListItemsRequest.<String>create()
            .contactListId(45006708003L)
            .contactNumbersField("workPhone")
            .contacts(Arrays.asList("12132212384", "12136612355", "12133312300"))
            .build();
        client.contactListsApi().addListItems(request2);

        AddContactListItemsRequest request3 = AddContactListItemsRequest.<Long>create()
            .contactListId(45006708003L)
            .contacts(Arrays.asList(800634185003L, 800734186003L, 800834187003L, 800984185003L))
            .build();
        client.contactListsApi().addListItems(request3);
    }
}
