using CallfireApiClient;

public class ApiClientSample
{
    public static void Main(string[] args)
    {
        var client = new CallfireClient("api_login", "api_password");
        var broadcast = client.TextBroadcastsApi.Get(11646003);
        broadcast.Name = "Campaign name updated";
        broadcast.Message = "a new test message";
        // update campaign
        client.TextBroadcastsApi.Update(broadcast);
    }
}

