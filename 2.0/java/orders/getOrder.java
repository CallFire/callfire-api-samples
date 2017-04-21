import com.callfire.api.client.CallfireClient;
import com.callfire.api.client.api.account.model.NumberOrder;

class ApiClientSample {
    public static void main(String[] args) {
        CallfireClient callfireClient = new CallfireClient("api_login", "api_password");
        Long orderId = 379506003L;
        NumberOrder order = callfireClient.ordersApi().getOrder(orderId, "status,totalCost");
    }
}
