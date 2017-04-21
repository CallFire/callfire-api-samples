import com.callfire.api.client.CallfireClient;
import com.callfire.api.client.api.common.model.Page;
import com.callfire.api.client.api.numbers.model.NumberConfig;
import com.callfire.api.client.api.numbers.model.request.FindNumberLeaseConfigsRequest;

class ApiClientSample {
    public static void main(String[] args) {
        FindNumberLeaseConfigsRequest request = FindNumberLeaseConfigsRequest.create()
            .prefix("14245")
            .city("Los Angeles")
            .state("CA")
            .zipcode("90940")
            .lata("123")
            .rateCenter("123")
            .labelName("my label")
            .offset(0L)
            .limit(10L)
            .fields("items(number,configType)")
            .build();
        CallfireClient client = new CallfireClient("api_login", "api_password");
        Page<NumberConfig> configs = client.numberLeasesApi().findConfigs(request);
    }
}
