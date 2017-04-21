import com.callfire.api.client.CallfireClient;

import java.util.Arrays;

class ApiClientSample {
    public static void main(String[] args) {
        CallfireClient client = new CallfireClient("api login", "api password");
        client.contactListsApi().removeListItems(11646003L, Arrays.asList(22277003L, 23377003L));
    }
}

