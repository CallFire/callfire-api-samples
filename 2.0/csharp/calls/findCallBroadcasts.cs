using CallfireApiClient;
using CallfireApiClient.Api.Campaigns.Model.Request;

public class ApiClientSample
{
    public static void Main(string[] args)
    {
        var client = new CallfireClient("api_login", "api_password");

        var findRequest = new FindBroadcastsRequest
        {
            Name = "campaign name",
            Limit = 2
        };
        var broadcasts = client.CallBroadcastsApi.Find(findRequest);
    }
}
