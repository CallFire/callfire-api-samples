using CallfireApiClient;
using CallfireApiClient.Api.Common.Model.Request;

public class ApiClientSample
{
    public static void Main(string[] args)
    {
        var client = new CallfireClient("api_login", "api_password");
        var request = new GetBroadcastCallsTextsRequest
        {
            Id = 11646003,
            BatchId = 5500030002,
            Offset = 0,
            Limit = 10,
            Fields = "items(fromNumber,toNumber,state,modified)"
        };
        var calls = client.CallBroadcastsApi.GetCalls(request);
    }
}
