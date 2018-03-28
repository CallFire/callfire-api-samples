using CallfireApiClient;

public class ApiClientSample
{
    public static void Main(string[] args)
    {
        var client = new CallfireClient("account_login", "account_password");
        client.MeApi.DeleteApiCredentials(425836003);
    }
}
