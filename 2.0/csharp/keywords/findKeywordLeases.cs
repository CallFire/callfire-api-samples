using CallfireApiClient;
using CallfireApiClient.Api.Common.Model;
using CallfireApiClient.Api.Common.Model.Request;
using CallfireApiClient.Api.Keywords.Model;

public class ApiClientSample
{
    public static void Main(string[] args)
    {
        var client = new CallfireClient("api_login", "api_password");
        var request = new CommonFindRequest
        {
            // pagination if needed
            Limit = 5,
            Offset = 10
        };
        Page<KeywordLease> leases = client.KeywordLeasesApi.Find(request);
    }
}
