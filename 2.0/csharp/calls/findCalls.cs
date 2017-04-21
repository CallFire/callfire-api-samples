using System;
using System.Collections.Generic;
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
            Id = new List<long> { 11646003, 12646003, 13776003 },
            CampaignId = 449060003,
            BatchId = 447060003,
            FromNumber = "12135551126",
            ToNumber  = "12136666123",
            Label = "my label",
            States = new List<StateType> { StateType.FINISHED, StateType.READY, StateType.INVALID },
            Results = new List<Call.CallResult> { Call.CallResult.LA },
            Inbound = true,
            IntervalBegin = new DateTime(2016, 9, 13, 15, 50, 17),
            IntervalEnd = new DateTime(2016, 9, 13, 15, 50, 17),
            Offset = 0,
            Limit = 10,
            Fields = "items(id,fromNumber,toNumber,modified,finalCallResult)"
        };
        Page<Call> calls = client.CallsApi.Find(request);
        // check Call.records.questionResponses for stored data
    }
}
