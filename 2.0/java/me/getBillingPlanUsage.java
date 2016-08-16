import com.callfire.api.client.CallfireClient;
import com.callfire.api.client.api.account.model.BillingPlanUsage;

class ApiClientSample {
    public static void main(String[] args) {
        CallfireClient callfireClient = new CallfireClient("api_login", "api_password");
        BillingPlanUsage billingPlanUsage = callfireClient.meApi().getBillingPlanUsage();
    }
}
