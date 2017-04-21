import com.callfire.api.client.CallfireClient;
import com.callfire.api.client.api.campaigns.model.Batch;

class ApiClientSample {
    public static void main(String[] args) {
        CallfireClient client = new CallfireClient("api_login", "api_password");
        Batch batch = client.batchesApi().get(379506003L);
        batch.setEnabled(true);
        client.batchesApi().update(batch);
    }
}
