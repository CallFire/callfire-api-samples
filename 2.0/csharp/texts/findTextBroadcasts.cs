using CallfireApiClient;
using CallfireApiClient.Api.Campaigns.Model;
using CallfireApiClient.Api.Campaigns.Model.Request;
using CallfireApiClient.Api.Common.Model;

public class ApiClientSample
{
    public static void Main(string[] args)
    {
        var client = new CallfireClient("api_login", "api_password");
        var request = new FindBroadcastsRequest
        {
            Name = "campaign name",
            Limit = 1
        };
        Page<TextBroadcast> broadcasts = client.TextBroadcastsApi.Find(request);
    }
}
