import com.callfire.api.client.CallfireClient;

class ApiClientSample {
    public static void main(String[] args) {
        CallfireClient callfireClient = new CallfireClient("account_login", "account_password");
        callfireClient.meApi().deleteApiCredentials(425836003L);
    }
}
