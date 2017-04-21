using System;
using CallfireApiClient;

public class ApiClientSample
{
    public static void Main(string[] args)
    {
        var client = new CallfireClient("api_login", "api_password");
        // limit returned fields if needed
        var fields = "totalOutboundCount,billedAmount,callsAttempted";
        var begin = new DateTime(2016, 9, 13, 15, 50, 17);
        var end = new DateTime(2016, 9, 13, 15, 50, 17);
        var stats = client.CallBroadcastsApi.GetStats(11646003, fields, begin, end);
    }
}
