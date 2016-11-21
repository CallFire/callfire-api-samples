import com.callfire.api.client.CallfireClient;

class ApiClientSample {
    public static void main(String[] args) {
        CallfireClient client = new CallfireClient("api_login", "api_password");
        Long id = 12345L;
        client.campaignSoundsApi().delete(id);
    }
}
