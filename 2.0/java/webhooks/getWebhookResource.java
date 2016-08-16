import com.callfire.api.client.CallfireClient;
import com.callfire.api.client.api.webhooks.WebhooksApi;
import com.callfire.api.client.api.webhooks.model.ResourceType;
import com.callfire.api.client.api.webhooks.model.WebhookResource;

class ApiClientSample {
    public static void main(String[] args) {
        CallfireClient client = new CallfireClient("api login", "api password");
        WebhooksApi api = client.webhooksApi();
        WebhookResource resource = api.findWebhookResource(ResourceType.CALL_BROADCAST, "resource");
    }
}
