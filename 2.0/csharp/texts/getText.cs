using CallfireApiClient;
using CallfireApiClient.Api.CallsTexts.Model;

public class ApiClientSample
{
    public static void Main(string[] args)
    {
        var client = new CallfireClient("api_login", "api_password");
        // limit returned fields if needed
        Text text = client.TextsApi.Get(379506003, "fromNumber,toNumber,modified,finalTextResult");
    }
}
