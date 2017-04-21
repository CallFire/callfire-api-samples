using CallfireApiClient;
using CallfireApiClient.Api.Numbers.Model;

public class ApiClientSample
{
    public static void Main(string[] args)
    {
        var client = new CallfireClient("api_login", "api_password");
        NumberConfig config = client.NumberLeasesApi.GetConfig("12132000384", "number,configType");
    }
}
