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
            Offset = 0,
            Limit = 10,
            Fields = "items(keyword,leaseBegin,leaseEnd)"
        };
        Page<KeywordLease> leases = client.KeywordLeasesApi.Find(request);
    }
}
