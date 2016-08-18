using System;
using CallfireApiClient;
using CallfireApiClient.Api.Campaigns.Model;

public class ApiClientSample
{
    public static void Main(string[] args)
    {
        var client = new CallfireClient("api_login", "api_password");
        var begin = DateTime.Now.AddDays(-5d);
        var end = DateTime.Now;
        BroadcastStats stats = client.TextBroadcastsApi.GetStats(8624192003L, null, begin, end);
    }
}
