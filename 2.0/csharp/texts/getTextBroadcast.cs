using CallfireApiClient;
using CallfireApiClient.Api.Campaigns.Model;

public class ApiClientSample
{
    public static void Main(string[] args)
    {
        var client = new CallfireClient("api_login", "api_password");
        TextBroadcast broadcast = client.TextBroadcastsApi.Get(379506003, "name,status,labels");
    }
}
