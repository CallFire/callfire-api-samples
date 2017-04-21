using CallfireApiClient;
using CallfireApiClient.Api.Numbers.Model;

public class ApiClientSample
{
    public static void Main(string[] args)
    {
        var client = new CallfireClient("api_login", "api_password");
        var lease = new NumberLease
        {
            PhoneNumber = "19206596476",
            AutoRenew = false,
            CallFeatureStatus = NumberLease.FeatureStatus.DISABLED
        };
        client.NumberLeasesApi.Update(lease);
    }
}
