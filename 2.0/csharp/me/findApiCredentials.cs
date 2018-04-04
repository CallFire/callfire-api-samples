using CallfireApiClient;
using CallfireApiClient.Api.Account.Model;
using CallfireApiClient.Api.Common.Model;
using CallfireApiClient.Api.Common.Model.Request;

public class ApiClientSample
{
    public static void Main(string[] args)
    {
        var client = new CallfireClient("account_login", "account_password");
        var request = new CommonFindRequest { Fields = "name,enabled" };
        Page<ApiCredentials> apiCredentials = client.MeApi.FindApiCredentials(request);
    }
}
