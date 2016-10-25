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

        var request = new FindCallsRequest
        {
            CampaignId = 10,
            Label = "reminders",
            IntervalBegin = new DateTime(2016, 12, 1, 0, 0, 0),
            IntervalEnd = new DateTime(2016, 12, 10, 0, 0, 0),
            Limit = 10
        };
        Page<Call> calls = client.CallsApi.Find(request);
        // check Call.records.questionResponses for stored data
    }
}
