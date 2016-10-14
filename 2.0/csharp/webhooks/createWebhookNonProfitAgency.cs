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
            Name = "OtboundCall webhook",
            Resource = ResourceType.OUTBOUND_CALL,
            Events = new HashSet<ResourceEvent> {ResourceEvent.FINISHED},
            Callback = "https://yoursite.com/callback"
        };
        ResourceId resource = client.WebhooksApi.Create(webhook);
    }
}
