using CallfireApiClient;
using CallfireApiClient.Api.Common.Model;
using CallfireApiClient.Api.Webhooks.Model;
using CallfireApiClient.Api.Webhooks.Model.Request;

public class ApiClientSample
{
    public static void Main(string[] args)
    {
        var client = new CallfireClient("api_login", "api_password");
        var request = new FindWebhooksRequest
        {
            Limit = 5,
            Enabled = true,
            Name = "test_name"
        };
        Page<Webhook> webhooks = client.WebhooksApi.Find(request);
    }
}
