using CallfireApiClient;
using CallfireApiClient.Api.CallsTexts.Model;

public class ApiClientSample
{
    public static void Main(string[] args)
    {
        var client = new CallfireClient("api_login", "api_password");
        // limit returned fields if needed
        Call call = client.CallsApi.Get(617067920003, "id,toNumber,state");
    }
}
