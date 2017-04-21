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
            Name = "Call finished webhook",
            Resource = ResourceType.OUTBOUND_CALL,
            Events = new HashSet<ResourceEvent> {ResourceEvent.FINISHED},
            Callback = "http://callback-service.com/webhook"
        };
        ResourceId resource = client.WebhooksApi.Create(webhook);
    }
}
