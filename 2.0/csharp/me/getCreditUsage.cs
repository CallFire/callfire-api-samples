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
            IntervalBegin = new DateTime(2037, 12, 31, 20, 53, 20),
            IntervalEnd = new DateTime(2038, 1, 1, 8, 0, 0)
        };
        CreditsUsage creditsUsage = client.MeApi.GetCreditUsage(request);
    }
}
