using System;
using CallfireApiClient;

public class ApiClientSample
{
    public static void Main(string[] args)
    {
        var client = new CallfireClient("api_login", "api_password");
        // limit returned fields if needed
        var fields = "callsAttempted,callsPlaced,callsDuration";
        var begin = DateTime.Now.AddDays(-5d);
        var end = DateTime.Now;
        var stats = client.CallBroadcastsApi.GetStats(8624192003L, fields, begin, end);
    }
}
