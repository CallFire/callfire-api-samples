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
            FromNumber = "12135551100",
            IntervalBegin = new DateTime(2016, 9, 13, 15, 50, 17),
            IntervalEnd = new DateTime(2016, 12, 1, 0, 0, 0),
            Offset = 100,
            Limit = 50,
            Fields = "items(id,message,created)"
        };
        Page<Text> texts = client.TextsApi.Find(request);
    }
}
