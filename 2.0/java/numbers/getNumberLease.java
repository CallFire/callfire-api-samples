import com.callfire.api.client.CallfireClient;
import com.callfire.api.client.api.numbers.model.NumberLease;

class ApiClientSample {
    public static void main(String[] args) {
        CallfireClient client = new CallfireClient("api_login", "api_password");
        NumberLease lease = client.numberLeasesApi().get("12132000384", "number,nationalFormat,leaseBegin,leaseEnd,region/city");
    }
}
