import com.callfire.api.client.CallfireClient;
import com.callfire.api.client.api.numbers.model.Number;
import com.callfire.api.client.api.numbers.model.request.FindNumbersLocalRequest;

import java.util.List;

class ApiClientSample {
    public static void main(String[] args) {
        CallfireClient client = new CallfireClient("api_login", "api_password");
        FindNumbersLocalRequest request = FindNumbersLocalRequest.create()
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
        List<Number> numbers = client.numbersApi().findNumbersLocal(request);
    }
}
