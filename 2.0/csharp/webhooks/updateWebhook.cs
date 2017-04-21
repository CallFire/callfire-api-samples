using System.Collections.Generic;
using CallfireApiClient;
using CallfireApiClient.Api.Webhooks.Model;

public class ApiClientSample
{
    public static void Main(string[] args)
    {
        var client = new CallfireClient("api_login", "api_password");
        var webhook = new Webhook
        {
            Id = 11646003,
            Name = "sms sent update",
            Resource = ResourceType.TEXT_BROADCAST,
            Events = new HashSet<ResourceEvent>
            {
                ResourceEvent.FINISHED
            },
            Callback = "https://callback-service.com/listener2"
        };
        client.WebhooksApi.Update(webhook);
    }
}
