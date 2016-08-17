using CallfireApiClient;

public class ApiClientSample
{
    public static void Main(string[] args)
    {
        var client = new CallfireClient("api_login", "api_password");
        var mp3 = client.CampaignSoundsApi.Upload("path/to/file.mp3", "fileName");
    }
}
