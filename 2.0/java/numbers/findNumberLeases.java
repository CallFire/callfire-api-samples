import com.callfire.api.client.CallfireClient;
import com.callfire.api.client.api.common.model.Page;
import com.callfire.api.client.api.numbers.model.NumberLease;
import com.callfire.api.client.api.numbers.model.request.FindNumberLeasesRequest;

class ApiClientSample {
    public static void main(String[] args) {
        CallfireClient client = new CallfireClient("api_login", "api_password");
        FindNumberLeasesRequest request = FindNumberLeasesRequest.create()
            .city("REDWOOD CITY")
            .build();
        Page<NumberLease> leases = client.numberLeasesApi().find(request);
    }
}
