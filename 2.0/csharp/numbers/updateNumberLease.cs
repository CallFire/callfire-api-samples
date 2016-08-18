using CallfireApiClient;
using CallfireApiClient.Api.Numbers.Model;

public class ApiClientSample
{
    public static void Main(string[] args)
    {
        var client = new CallfireClient("api_login", "api_password");
        var lease = new NumberLease
        {
            PhoneNumber = "16502572135",
            AutoRenew = true
        };
        client.NumberLeasesApi.Update(lease);
    }
}
