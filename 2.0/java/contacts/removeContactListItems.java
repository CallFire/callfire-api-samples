import com.callfire.api.client.CallfireClient;

import java.util.Arrays;

class ApiClientSample {
    public static void main(String[] args) {
        CallfireClient client = new CallfireClient("api login", "api password");
        client.contactListsApi().removeListItems(123456L, Arrays.asList(123456L, 111111L, 222222L));
    }
}
