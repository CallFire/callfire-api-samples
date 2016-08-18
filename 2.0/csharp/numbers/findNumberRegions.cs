using CallfireApiClient;
using CallfireApiClient.Api.Common.Model;
using CallfireApiClient.Api.Numbers.Model;
using CallfireApiClient.Api.Numbers.Model.Request;

public class ApiClientSample
{
    public static void Main(string[] args)
    {
        var client = new CallfireClient("api_login", "api_password");
        var request = new FindNumberRegionsRequest
        {
            Limit = 2,
            State = "IL",
            Zipcode = "60640"
        };
        Page<Region> regions = client.NumbersApi.FindNumberRegions(request);
    }
}
