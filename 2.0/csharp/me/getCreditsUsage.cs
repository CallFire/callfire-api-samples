using System;
using CallfireApiClient;
using CallfireApiClient.Api.Account.Model;
using CallfireApiClient.Api.Account.Model.Request;

public class ApiClientSample
{
    public static void Main(string[] args)
    {
        var client = new CallfireClient("api_login", "api_password");
        var request = new DateIntervalRequest
        {
            IntervalBegin = DateTime.UtcNow.AddMonths(-2),
            IntervalEnd = DateTime.UtcNow
        };
        CreditsUsage creditsUsage = client.MeApi.GetCreditUsage(request);
    }
}
