using CallfireApiClient;
using CallfireApiClient.Api.Common.Model.Request;

public class ApiClientSample
{
    public static void Main(string[] args)
    {
        var client = new CallfireClient("api_login", "api_password");
        var request = new GetBroadcastCallsTextsRequest {Id = 1234, batchId = 12345};
        var calls = client.CallBroadcastsApi.GetCalls(request);
    }
}
