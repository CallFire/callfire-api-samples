using CallfireApiClient;
using CallfireApiClient.Api.Account.Model;
using CallfireApiClient.Api.Common.Model;
using CallfireApiClient.Api.Common.Model.Request;

public class ApiClientSample
{
    public static void Main(string[] args)
    {
        var client = new CallfireClient("api_login", "api_password");
        var request = new CommonFindRequest {Limit = 2};
        Page<ApiCredentials> apiCredentials = client.MeApi.FindApiCredentials(request);
    }
}
