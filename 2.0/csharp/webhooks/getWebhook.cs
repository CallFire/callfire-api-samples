using CallfireApiClient;
using CallfireApiClient.Api.Webhooks.Model;

public class ApiClientSample
{
    public static void Main(string[] args)
    {
        var client = new CallfireClient("api_login", "api_password");
        Webhook webhook = client.WebhooksApi.Get(379506003, "name,callback");
    }
}
