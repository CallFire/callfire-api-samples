using System;
using CallfireApiClient;
using CallfireApiClient.Api.Campaigns.Model;

public class ApiClientSample
{
    public static void Main(string[] args)
    {
        var client = new CallfireClient("api_login", "api_password");
        var begin = new DateTime(2016, 9, 13, 15, 50, 17);
        var end = new DateTime(2016, 9, 13, 15, 50, 17);
        BroadcastStats stats = client.TextBroadcastsApi.GetStats(11646003, "totalOutboundCount,billedAmount,sentCount", begin, end);
    }
}
