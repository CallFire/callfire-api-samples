using CallfireApiClient;
using CallfireApiClient.Api.CallsTexts.Model;

public class ApiClientSample
{
    public static void Main(string[] args)
    {
        var client = new CallfireClient("api_login", "api_password");
        Call call = client.CallsApi.Get(379506003, "fromNumber,toNumber,modified,finalCallResult");
    }
}
