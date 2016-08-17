using CallfireApiClient;
using CallfireApiClient.Api.Campaigns.Model;

public class ApiClientSample
{
    public static void Main(string[] args)
    {
        var client = new CallfireClient("api_login", "api_password");
        Batch batch = client.BatchesApi.Get(1234);
    }
}
