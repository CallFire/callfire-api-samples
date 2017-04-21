import com.callfire.api.client.CallfireClient;
import com.callfire.api.client.api.common.model.Page;
import com.callfire.api.client.api.webhooks.model.ResourceType;
import com.callfire.api.client.api.webhooks.model.Webhook;
import com.callfire.api.client.api.webhooks.model.request.FindWebhooksRequest;

class ApiClientSample {
    public static void main(String[] args) {
        CallfireClient client = new CallfireClient("api login", "api password");
        FindWebhooksRequest request = FindWebhooksRequest.create()
            .name("my webhook")
            .resource(ResourceType.TEXT_BROADCAST)
            .event(ResourceType.ResourceEvent.STARTED)
            .callback("https://myservice/callback")
            .enabled(true)
            .offset(0L)
            .limit(10L)
            .fields("items(id,name,callback)")
            .enabled(true)
            .build();
        Page<Webhook> webhooks = client.webhooksApi().find(request);
    }
}
