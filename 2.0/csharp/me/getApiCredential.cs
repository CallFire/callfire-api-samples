using CallfireApiClient;
using CallfireApiClient.Api.Account.Model;

public class ApiClientSample
{
    public static void Main(string[] args)
    {
        var client = new CallfireClient("account_login", "account_password");
        // add 2nd argument to limit returned fields
        ApiCredentials credentials = client.MeApi.GetApiCredentials(379506003, "name,enabled");
    }
}
