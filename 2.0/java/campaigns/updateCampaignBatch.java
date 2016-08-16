import com.callfire.api.client.CallfireClient;
import com.callfire.api.client.api.campaigns.model.Batch;

class ApiClientSample {
    public static void main(String[] args) {
        CallfireClient client = new CallfireClient("api_login", "api_password");
        Batch batch = client.batchesApi().get(1234L);
        batch.setEnabled(false);
        client.batchesApi().update(batch);
        Batch updatedBatch = client.batchesApi().get(1234L);
    }
}
