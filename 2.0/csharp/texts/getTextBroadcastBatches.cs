using CallfireApiClient;
using CallfireApiClient.Api.Common.Model.Request;

public class ApiClientSample
{
    public static void Main(string[] args)
    {
        var client = new CallfireClient("api_login", "api_password");
        var request = new GetByIdRequest
        {
            Id = 11646003,
            Offset = 0,
            Limit = 10,
            Fields = "items(name,status,size,remaining)"
        };
        var batches = client.TextBroadcastsApi.GetBatches(request);
    }
}
