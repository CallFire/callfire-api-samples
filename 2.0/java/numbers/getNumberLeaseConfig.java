import com.callfire.api.client.CallfireClient;
import com.callfire.api.client.api.numbers.model.NumberConfig;

class ApiClientSample {
    public static void main(String[] args) {
        CallfireClient client = new CallfireClient("api_login", "api_password");
        NumberConfig config = client.numberLeasesApi().getConfig("16502572135");
    }
}
