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
            States = new List<StateType> {StateType.FINISHED, StateType.READY},
            IntervalBegin = DateTime.UtcNow.AddMonths(-2),
            IntervalEnd = DateTime.UtcNow,
            Limit = 3
        };
        Page<Call> calls = client.CallsApi.Find(request);
        // check Call.records.questionResponses for stored data
    }
}
