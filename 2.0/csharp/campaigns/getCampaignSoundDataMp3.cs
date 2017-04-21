using System.IO;
using CallfireApiClient;

public class ApiClientSample
{
    public static void Main(string[] args)
    {
        var client = new CallfireClient("api_login", "api_password");
        Stream stream = client.CampaignSoundsApi.GetMp3(379506003);
    }
}
