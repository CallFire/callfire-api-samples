import com.callfire.api.client.CallfireClient;
import com.callfire.api.client.api.account.model.NumberOrder;

class ApiClientSample {
    public static void main(String[] args) {
        CallfireClient callfireClient = new CallfireClient("api_login", "api_password");
        Long orderId = 123456L;
        NumberOrder order = callfireClient.ordersApi().getOrder(orderId, "id,status");
    }
}
