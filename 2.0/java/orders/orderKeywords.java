import com.callfire.api.client.CallfireClient;
import com.callfire.api.client.api.common.model.ResourceId;
import com.callfire.api.client.api.keywords.model.request.KeywordPurchaseRequest;

import java.util.Arrays;

class ApiClientSample {
    public static void main(String[] args) {
        CallfireClient callfireClient = new CallfireClient("api_login", "api_password");
        KeywordPurchaseRequest request = KeywordPurchaseRequest.create()
            .keywords(Arrays.asList("SUN", "MOON")).build();
        ResourceId resourceId = callfireClient.ordersApi().orderKeywords(request);
    }
}
