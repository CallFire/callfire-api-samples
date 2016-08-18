using CallfireApiClient;

public class ApiClientSample
{
    public static void Main(string[] args)
    {
        var client = new CallfireClient("api_login", "api_password");
        var lease = client.KeywordLeasesApi.Get("CALLFIRE");
    }
}
