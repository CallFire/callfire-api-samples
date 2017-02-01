import com.callfire.api.client.CallfireClient;
import com.callfire.api.client.api.contacts.model.request.UpdateDncRequest;

class ApiClientSample {
    public static void main(String[] args) {
        CallfireClient client = new CallfireClient("api login", "api password");
        UpdateDncRequest request = UpdateDncRequest.create()
            // prohibit dialing to phone number
            .call(true)
            // allow text messaging
            .text(false)
            .number("12135551188")
            .build();
        client.dncApi().update(request);
    }
}
