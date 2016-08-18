using CallfireApiClient;
using CallfireApiClient.Api.Keywords.Model;

public class ApiClientSample
{
    public static void Main(string[] args)
    {
        var client = new CallfireClient("api_login", "api_password");
        var lease = new KeywordLease
        {
            KeywordName = "CALLFIRE",
            AutoRenew = false
        };
        client.KeywordLeasesApi.Update(lease);
    }
}
