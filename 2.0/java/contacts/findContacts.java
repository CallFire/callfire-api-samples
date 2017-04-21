import com.callfire.api.client.CallfireClient;
import com.callfire.api.client.api.common.model.Page;
import com.callfire.api.client.api.contacts.model.Contact;
import com.callfire.api.client.api.contacts.model.request.FindContactsRequest;

import java.util.Arrays;

class ApiClientSample {
    public static void main(String[] args) {
        CallfireClient client = new CallfireClient("api login", "api password");
        FindContactsRequest request = FindContactsRequest.create()
            .id(Arrays.asList(11646003L, 12646003L, 13776003L))
            .number(Arrays.asList("12135551126", "12136666123"))
            .contactListId(14400809003L)
            .propertyName("14400809003")
            .propertyValue("14400809003")
            .offset(0L)
            .limit(10L)
            .build();
        Page<Contact> contacts = client.contactsApi().find(request);
    }
}
