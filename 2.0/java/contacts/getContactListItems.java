import com.callfire.api.client.CallfireClient;
import com.callfire.api.client.api.common.model.request.GetByIdRequest;

class ApiClientSample {
    public static void main(String[] args) {
        CallfireClient client = new CallfireClient("api login", "api password");
        client.contactListsApi().getListItems(GetByIdRequest.create().id(123456L).build());
    }
}
