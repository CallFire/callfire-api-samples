using CallfireApiClient;
using CallfireApiClient.Api.Campaigns.Model.Request;

public class ApiClientSample
{
    public static void Main(string[] args)
    {
        var client = new CallfireClient("api_login", "api_password");

        var findRequest = new FindBroadcastsRequest
        {
            Name = "broadcast name",
            Label = "my label",
            Running = true,
            Offset = 0,
            Limit = 10,
            Fields = "items(id,name,status,sounds)"
        };
        var broadcasts = client.CallBroadcastsApi.Find(findRequest);
    }
}
