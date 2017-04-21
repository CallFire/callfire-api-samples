import com.callfire.api.client.CallfireClient;
import com.callfire.api.client.api.campaigns.model.Batch;
import com.callfire.api.client.api.common.model.Page;
import com.callfire.api.client.api.common.model.request.GetByIdRequest;

class ApiClientSample {
    public static void main(String[] args) {
        CallfireClient client = new CallfireClient("api_login", "api_password");
        GetByIdRequest request = GetByIdRequest.create()
            .id(11646003L)
            .offset(0L)
            .limit(10L)
            .fields("items(name,status,size,remaining)")
            .build();
        Page<Batch> batches = client.textBroadcastsApi().getBatches(request);
    }
}
