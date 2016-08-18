using System.Collections.Generic;
using CallfireApiClient;
using CallfireApiClient.Api.Common.Model;
using CallfireApiClient.Api.Webhooks.Model;

public class ApiClientSample
{
    public static void Main(string[] args)
    {
        var client = new CallfireClient("api_login", "api_password");
        var webhook = new Webhook
        {
            Name = "new webhook",
            Resource = ResourceType.TEXT_BROADCAST,
            Events = new HashSet<ResourceEvent> {ResourceEvent.STARTED, ResourceEvent.FINISHED},
            Callback = "https://yoursite.com/callback"
        };
        ResourceId resource = client.WebhooksApi.Create(webhook);
    }
}
