import com.callfire.api.client.CallfireClient;
import com.callfire.api.client.api.common.model.request.GetByIdRequest;

class ApiClientSample {
    public static void main(String[] args) {
        CallfireClient client = new CallfireClient("api login", "api password");

        GetByIdRequest request = GetByIdRequest.create()
            .id(379506003L)
            .offset(0L)
            .limit(10L)
            .fields("items(firstName,lastName,workPhone)")
            .build();
        client.contactListsApi().getListItems(request);
    }
}

