using CallfireApiClient;
using CallfireApiClient.Api.Webhooks.Model;

public class ApiClientSample
{
    public static void Main(string[] args)
    {
        var client = new CallfireClient("api_login", "api_password");
        var resource = client.WebhooksApi.FindWebhookResource(ResourceType.CALL_BROADCAST, "resource,events");
    }
}
