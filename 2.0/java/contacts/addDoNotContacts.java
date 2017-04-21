import java.util.Arrays;

import com.callfire.api.client.CallfireClient;
import com.callfire.api.client.api.contacts.model.request.CreateDncsRequest;

class ApiClientSample {
    public static void main(String[] args) {
        CallfireClient client = new CallfireClient("api login", "api password");
        CreateDncsRequest request = CreateDncsRequest.create()
            // prohibit dialing to given phone numbers
            .call(true)
            // prohibit texting to given phone numbers
            .text(true)
            // the list of phone numbers
            .numbers(Arrays.asList("12132000381", "12132000382", "12132000383"))
            // optional the name of the source
            .source("My DNC list 1")
            .build();
        client.dncApi().create(request);
    }
}
