import com.callfire.api.client.CallfireClient;
import com.callfire.api.client.api.numbers.model.Number;
import com.callfire.api.client.api.numbers.model.request.FindTollfreeNumbersRequest;

import java.util.List;

class ApiClientSample {
    public static void main(String[] args) {
        CallfireClient client = new CallfireClient("api_login", "api_password");
        FindTollfreeNumbersRequest request = FindTollfreeNumbersRequest.create()
            .pattern("87*")
            .limit(10L)
            .fields("number")
            .build();
        List<Number> numbers = client.numbersApi().findNumbersTollfree(request);
    }
}
