import com.callfire.api.client.CallfireClient;
import com.callfire.api.client.api.common.model.request.GetByIdRequest;
import com.callfire.api.client.api.contacts.model.ContactHistory;

class ApiClientSample {
    public static void main(String[] args) {
        CallfireClient client = new CallfireClient("api login", "api password");
        GetByIdRequest request = GetByIdRequest.create()
            .id(379506003L)
            .offset(0L)
            .limit(10L)
            .fields("calls/fromNumber,calls/toNumber,texts/message")
            .build();
        ContactHistory history = client.contactsApi().getHistory(request);
    }
}

