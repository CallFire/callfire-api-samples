import com.callfire.api.client.CallfireClient;
import com.callfire.api.client.api.common.model.Page;
import com.callfire.api.client.api.webhooks.model.Webhook;
import com.callfire.api.client.api.webhooks.model.request.FindWebhooksRequest;

class ApiClientSample {
    public static void main(String[] args) {
        CallfireClient client = new CallfireClient("api login", "api password");
        FindWebhooksRequest request = FindWebhooksRequest.create()
            .limit(5L)
            .enabled(true)
            .name("test_name")
            .build();
        Page<Webhook> webhooks = client.webhooksApi().find(request);
    }
}
