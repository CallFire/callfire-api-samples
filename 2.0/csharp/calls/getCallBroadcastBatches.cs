using CallfireApiClient;
using CallfireApiClient.Api.Common.Model.Request;

public class ApiClientSample
{
    public static void Main(string[] args)
    {
        var client = new CallfireClient("api_login", "api_password");
        var request = new GetByIdRequest {Id = 1234};
        var batches = client.CallBroadcastsApi.GetBatches(request);
    }
}
