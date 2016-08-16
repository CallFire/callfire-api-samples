import com.callfire.api.client.CallfireClient;
import com.callfire.api.client.api.common.model.ResourceId;

import java.io.File;

class ApiClientSample {
    public static void main(String[] args) {
        CallfireClient client = new CallfireClient("api login", "api password");
        File file = new File("/contacts/contacts-list.csv");
        ResourceId resourceId = client.contactListsApi().createFromCsv("New contact list", file);
    }
}
