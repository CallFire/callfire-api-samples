import com.callfire.api.client.CallfireClient;
import com.callfire.api.client.api.common.model.Page;
import com.callfire.api.client.api.numbers.model.NumberConfig;
import com.callfire.api.client.api.numbers.model.request.FindNumberLeaseConfigsRequest;

class ApiClientSample {
    public static void main(String[] args) {
        FindNumberLeaseConfigsRequest request = FindNumberLeaseConfigsRequest.create().build();
        CallfireClient client = new CallfireClient("api_login", "api_password");
        Page<NumberConfig> configs = client.numberLeasesApi().findConfigs(request);
    }
}
