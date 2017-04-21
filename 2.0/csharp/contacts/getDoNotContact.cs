using CallfireApiClient;
using CallfireApiClient.Api.Contacts.Model;

public class ApiClientSample
{
    public static void Main(string[] args)
    {
        var client = new CallfireClient("api_login", "api_password");
        DoNotContact dnc = client.DncApi.Get("12135551126");
    }
}
