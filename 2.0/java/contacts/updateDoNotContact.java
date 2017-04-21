import com.callfire.api.client.CallfireClient;
import com.callfire.api.client.api.contacts.model.request.UpdateDncRequest;

class ApiClientSample {
    public static void main(String[] args) {
        CallfireClient client = new CallfireClient("api login", "api password");
        UpdateDncRequest request = UpdateDncRequest.create()
            .call(true)
            .text(false)
            .number("'12132000381'")
            .build();
        client.dncApi().update(request);
    }
}
