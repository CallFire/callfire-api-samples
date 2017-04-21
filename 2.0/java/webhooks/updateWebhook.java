import com.callfire.api.client.CallfireClient;
import com.callfire.api.client.api.webhooks.model.ResourceType;
import com.callfire.api.client.api.webhooks.model.Webhook;

class ApiClientSample {
    public static void main(String[] args) {
        CallfireClient client = new CallfireClient("api login", "api password");
        Webhook webhook = client.webhooksApi().get(11646003L);
        webhook.setName("sms sent update");
        webhook.getEvents().add(ResourceType.ResourceEvent.FINISHED);
        webhook.setCallback("https://callback-service.com/listener2");
        client.webhooksApi().update(webhook);
    }
}
