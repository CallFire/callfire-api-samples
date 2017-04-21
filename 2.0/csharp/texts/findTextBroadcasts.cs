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
            Name = "broadcast name",
            Label = "my label",
            Running = true,
            Offset = 0,
            Limit = 10,
            Fields = "items(id,name,status,message)"
        };
        Page<TextBroadcast> broadcasts = client.TextBroadcastsApi.Find(request);
    }
}
