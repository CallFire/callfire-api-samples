import com.callfire.api.client.CallfireClient;
import com.callfire.api.client.api.common.model.ResourceId;
import com.callfire.api.client.api.webhooks.model.ResourceType;
import com.callfire.api.client.api.webhooks.model.Webhook;

class ApiClientSample {
    public static void main(String[] args) {
        CallfireClient client = new CallfireClient("api_login", "api_password");
        
        Webhook webhook = new Webhook();
        webhook.setName("OutboundCall webhook");
        webhook.setResource(ResourceType.OUTBOUND_CALL);
        webhook.getEvents().add(ResourceType.ResourceEvent.FINISHED);
        // CallFire will send a POST request to specified endpoint
        webhook.setCallback("https://yoursite.com/callback");
        ResourceId id = client.webhooksApi().create(webhook);
    }
}

