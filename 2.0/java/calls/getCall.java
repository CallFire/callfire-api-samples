import com.callfire.api.client.CallfireClient;
import com.callfire.api.client.api.callstexts.model.Call;

class ApiClientSample {
    public static void main(String[] args) {
        CallfireClient client = new CallfireClient("api_login", "api_password");
        Call call = client.callsApi().get(617067920003L);
    }
}
