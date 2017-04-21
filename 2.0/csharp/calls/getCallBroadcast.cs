using CallfireApiClient;

public class ApiClientSample
{
    public static void Main(string[] args)
    {
        var client = new CallfireClient("api_login", "api_password");
        var broadcast = client.CallBroadcastsApi.Get(379506003, "name,status,labels");
    }
}
