import com.callfire.api.client.CallfireClient;
import com.callfire.api.client.api.common.model.Page;
import com.callfire.api.client.api.numbers.model.Region;
import com.callfire.api.client.api.numbers.model.request.FindNumberRegionsRequest;

class ApiClientSample {
    public static void main(String[] args) {
        CallfireClient client = new CallfireClient("api_login", "api_password");
        FindNumberRegionsRequest request = FindNumberRegionsRequest.create()
            .prefix("14245")
            .city("Los Angeles")
            .state("CA")
            .zipcode("90940")
            .lata("123")
            .rateCenter("123")
            .offset(0L)
            .limit(10L)
            .fields("items(number,nationalFormat,leaseBegin,leaseEnd,region/city)")
            .build();
        Page<Region> regions = client.numbersApi().findNumberRegions(request);
    }
}
