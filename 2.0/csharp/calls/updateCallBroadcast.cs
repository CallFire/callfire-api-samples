using CallfireApiClient;
using CallfireApiClient.Api.Campaigns.Model;

public class ApiClientSample
{
    public static void Main(string[] args)
    {
        var client = new CallfireClient("api_login", "api_password");
        var broadcast = client.CallBroadcastsApi.Get(123L);
        // time restrictions
        broadcast.LocalTimeRestriction = new LocalTimeRestriction
        {
            BeginHour = 10,
            BeginMinute = 10,
            EndHour = 22,
            EndMinute = 0,
            Enabled = true
        };
        // update campaign
        client.CallBroadcastsApi.Update(broadcast);
    }
}
