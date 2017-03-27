import com.callfire.api.client.CallfireClient;
import com.callfire.api.client.api.common.model.ResourceId;
import com.callfire.api.client.api.webhooks.model.ResourceType;
import com.callfire.api.client.api.webhooks.model.Webhook;

class ApiClientSample {
    public static void main(String[] args) {
        CallfireClient client = new CallfireClient("api login", "api password");
        Webhook webhook = new Webhook();
        webhook.setName("inbound sms webhook");
        webhook.setResource(ResourceType.INBOUND_TEXT);
        webhook.getEvents().add(ResourceType.ResourceEvent.FINISHED);
        webhook.setCallback("https://callback-service.com/listener");
        ResourceId id = client.webhooksApi().create(webhook);
    }
}
