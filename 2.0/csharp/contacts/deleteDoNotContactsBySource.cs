using CallfireApiClient;

public class ApiClientSample
{
    public static void Main(string[] args)
    {
        var client = new CallfireClient("api_login", "api_password");
        client.DncApi.DeleteDncsFromSource("My DNC Source 1");
    }
}
