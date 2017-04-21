import com.callfire.api.client.CallfireClient;
import com.callfire.api.client.api.campaigns.model.Batch;

class ApiClientSample {
    public static void main(String[] args) {
        CallfireClient callfireClient = new CallfireClient("api_login", "api_password");
        Batch batch = callfireClient.batchesApi().get(379506003L, "name,lengthInSeconds");
    }
}
