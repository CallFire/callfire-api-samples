import com.callfire.api.client.CallfireClient;
import com.callfire.api.client.api.account.model.ApiCredentials;

class ApiClientSample {
    public static void main(String[] args) {
        CallfireClient callfireClient = new CallfireClient("account_login", "account_password");
        // you can use 'fields' argument to limit returned fields
        ApiCredentials credentials = callfireClient.meApi().getApiCredentials(123456L, "name,enabled");
    }
}
