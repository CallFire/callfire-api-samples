import com.callfire.api.client.CallfireClient;
import com.callfire.api.client.api.common.model.Page;
import com.callfire.api.client.api.contacts.model.Contact;
import com.callfire.api.client.api.contacts.model.request.FindContactsRequest;

import java.util.Arrays;

class ApiClientSample {
    public static void main(String[] args) {
        CallfireClient client = new CallfireClient("api login", "api password");
        FindContactsRequest request = FindContactsRequest.create()
            .limit(1L)
            .offset(5L)
            .id(Arrays.asList(463633187003L, 466225637003L))
            .build();
        Page<Contact> contacts = client.contactsApi().find(request);
    }
}
