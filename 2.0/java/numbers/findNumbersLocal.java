import com.callfire.api.client.CallfireClient;
import com.callfire.api.client.api.numbers.model.Number;
import com.callfire.api.client.api.numbers.model.request.FindNumbersLocalRequest;

import java.util.List;

class ApiClientSample {
    public static void main(String[] args) {
        CallfireClient client = new CallfireClient("api_login", "api_password");
        // find 2 available local numbers by zipcode
        FindNumbersLocalRequest request = FindNumbersLocalRequest.create()
            .zipcode("90401")
            .limit(2L)
            .build();
        List<Number> numbers = client.numbersApi().findNumbersLocal(request);
    }
}
