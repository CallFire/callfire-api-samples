import com.callfire.api.client.CallfireClient;
import com.callfire.api.client.api.common.model.Page;
import com.callfire.api.client.api.numbers.model.Region;
import com.callfire.api.client.api.numbers.model.request.FindNumberRegionsRequest;

class ApiClientSample {
    public static void main(String[] args) {
        CallfireClient client = new CallfireClient("api_login", "api_password");
        FindNumberRegionsRequest request = FindNumberRegionsRequest.create()
            .limit(2L)
            .state("IL")
            .zipcode("60640")
            .build();
        Page<Region> regions = client.numbersApi().findNumberRegions(request);
    }
}
