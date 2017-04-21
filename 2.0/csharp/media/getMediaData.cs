using System.IO;
using CallfireApiClient;
using CallfireApiClient.Api.CallsTexts.Model;

public class ApiClientSample
{
    public static void Main(string[] args)
    {
        var client = new CallfireClient("api_login", "api_password");
        Stream stream = client.MediaApi.GetData(379506003, MediaType.MP3);
    }
}
