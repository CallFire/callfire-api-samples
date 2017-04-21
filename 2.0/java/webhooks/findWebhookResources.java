import com.callfire.api.client.CallfireClient;
import com.callfire.api.client.api.webhooks.WebhooksApi;
import com.callfire.api.client.api.webhooks.model.WebhookResource;

import java.util.List;

class ApiClientSample {
    public static void main(String[] args) {
        CallfireClient client = new CallfireClient("api login", "api password");
        WebhooksApi api = client.webhooksApi();
        List<WebhookResource> resources = api.findWebhookResources("items(events)");
    }
}
