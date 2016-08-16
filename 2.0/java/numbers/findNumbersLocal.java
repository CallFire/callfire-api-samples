import com.callfire.api.client.CallfireClient;
import com.callfire.api.client.api.numbers.model.Number;
import com.callfire.api.client.api.numbers.model.request.FindNumbersLocalRequest;

import java.util.List;

class ApiClientSample {
    public static void main(String[] args) {
        CallfireClient client = new CallfireClient("api_login", "api_password");
        //At least one parameter is required
        FindNumbersLocalRequest request = FindNumbersLocalRequest.create()
            .state("LA")
            .build();
        List<Number> numbers = client.numbersApi().findNumbersLocal(request);
    }
}
