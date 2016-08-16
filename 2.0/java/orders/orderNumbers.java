import com.callfire.api.client.CallfireClient;
import com.callfire.api.client.api.common.model.ResourceId;
import com.callfire.api.client.api.numbers.model.request.NumberPurchaseRequest;

import java.util.Arrays;

class ApiClientSample {
    public static void main(String[] args) {
        CallfireClient callfireClient = new CallfireClient("api_login", "api_password");
        // request for buying particular numbers
        NumberPurchaseRequest request = NumberPurchaseRequest.create()
            .numbers(Arrays.asList("12131234567", "12131234568"))
            .build();
        ResourceId resourceId = callfireClient.ordersApi().orderNumbers(request);

        // request for buying numbers in specific area
        NumberPurchaseRequest request2 = NumberPurchaseRequest.create()
            .zipcode("90401")
            .localCount(2)
            .build();
        ResourceId resourceId2 = callfireClient.ordersApi().orderNumbers(request2);
    }
}
