import com.callfire.api.client.CallfireClient;

class ApiClientSample {
    public static void main(String[] args) {
        CallfireClient client = new CallfireClient("api_login", "api_password");
        Boolean available = client.keywordsApi().isAvailable("FIRE");
    }
}
