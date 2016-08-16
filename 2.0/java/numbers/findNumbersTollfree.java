import com.callfire.api.client.CallfireClient;
import com.callfire.api.client.api.common.model.request.CommonFindRequest;
import com.callfire.api.client.api.numbers.model.Number;

import java.util.List;

class ApiClientSample {
    public static void main(String[] args) {
        CallfireClient client = new CallfireClient("api_login", "api_password");
        CommonFindRequest request = CommonFindRequest.create()
            .limit(1L)
            .offset(1L)
            .build();
        List<Number> numbers = client.numbersApi().findNumbersTollfree(request);
    }
}
