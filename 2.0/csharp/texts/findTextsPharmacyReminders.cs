using System;
using CallfireApiClient;
using CallfireApiClient.Api.CallsTexts.Model;
using CallfireApiClient.Api.CallsTexts.Model.Request;
using CallfireApiClient.Api.Common.Model;

public class ApiClientSample
{
    public static void Main(string[] args)
    {
        var client = new CallfireClient("api_login", "api_password");
        var request = new FindTextsRequest
        {
            // find all texts which belong to a particular campaign and were sent between
            // 2015-12-01 and 2015-12-10
            CampaignId = 13,
            Label = "reminders",
            IntervalBegin = new DateTime(2016, 12, 1, 0, 0, 0),
            IntervalEnd = new DateTime(2016, 12, 1, 0, 0, 0),
            Limit = 10
        };
        Page<Text> texts = client.TextsApi.Find(request);
    }
}
