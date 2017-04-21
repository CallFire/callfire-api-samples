import com.callfire.api.client.CallfireClient;
import com.callfire.api.client.api.account.model.ApiCredentials;

class ApiClientSample {
    public static void main(String[] args) {
        CallfireClient callfireClient = new CallfireClient("account_login", "account_password");
        ApiCredentials credentials = new ApiCredentials();
        credentials.setName("api-integration");
        credentials = callfireClient.meApi().createApiCredentials(credentials);
    }
}
