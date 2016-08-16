import com.callfire.api.client.CallfireClient;
import com.callfire.api.client.api.account.model.Account;

class ApiClientSample {
    public static void main(String[] args) {
        CallfireClient callfireClient = new CallfireClient("api_login", "api_password");
        Account account = callfireClient.meApi().getAccount();
    }
}
