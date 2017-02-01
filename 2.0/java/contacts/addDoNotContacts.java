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
            .numbers(Arrays.asList("12135551188", "12135771124"))
            // optional the name of the source
            .source("My DNCs List 1")
            .build();
        client.dncApi().create(request);
    }
}
