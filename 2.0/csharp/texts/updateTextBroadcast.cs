using CallfireApiClient;
using CallfireApiClient.Api.Campaigns.Model;

public class ApiClientSample
{
    public static void Main(string[] args)
    {
        var client = new CallfireClient("api_login", "api_password");
        var broadcast = client.TextBroadcastsApi.Get(123456);
        broadcast.Name = "New name";
        broadcast.FromNumber = "67076";
        broadcast.BigMessageStrategy = BigMessageStrategy.DO_NOT_SEND;
        // update campaign
        client.TextBroadcastsApi.Update(broadcast);
    }
}
