import com.callfire.api.client.CallfireClient;
import com.callfire.api.client.api.common.model.Page;
import com.callfire.api.client.api.numbers.model.NumberLease;
import com.callfire.api.client.api.numbers.model.request.FindNumberLeasesRequest;

class ApiClientSample {
    public static void main(String[] args) {
        CallfireClient client = new CallfireClient("api_login", "api_password");
        FindNumberLeasesRequest request = FindNumberLeasesRequest.create()
            .prefix("14245")
            .city("Los Angeles")
            .state("CA")
            .zipcode("90940")
            .lata("123")
            .rateCenter("123")
            .labelName("my label")
            .offset(0L)
            .limit(10L)
            .fields("items(number,nationalFormat,leaseBegin,leaseEnd,region/city)")
            .build();
        Page<NumberLease> leases = client.numberLeasesApi().find(request);
    }
}
