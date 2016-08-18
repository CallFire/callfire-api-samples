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
        var request = new FindTextsRequest
        {
            States = new List<StateType> {StateType.FINISHED, StateType.READY},
            Results = new List<TextRecord.TextResult> {TextRecord.TextResult.SENT, TextRecord.TextResult.RECEIVED},
            Limit = 2
        };
        Page<Text> texts = client.TextsApi.Find(request);
    }
}
