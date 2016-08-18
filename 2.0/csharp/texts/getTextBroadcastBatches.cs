using CallfireApiClient;
using CallfireApiClient.Api.Common.Model.Request;

public class ApiClientSample
{
    public static void Main(string[] args)
    {
        var client = new CallfireClient("api_login", "api_password");
        var request = new GetByIdRequest
        {
            Id = 123456,
            Limit = 10
        };
        var batches = client.TextBroadcastsApi.GetBatches(request);
    }
}
