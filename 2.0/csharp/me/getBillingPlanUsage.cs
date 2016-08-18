using CallfireApiClient;
using CallfireApiClient.Api.Account.Model;

public class ApiClientSample
{
    public static void Main(string[] args)
    {
        var client = new CallfireClient("api_login", "api_password");
        BillingPlanUsage usage = client.MeApi.GetBillingPlanUsage();
    }
}
