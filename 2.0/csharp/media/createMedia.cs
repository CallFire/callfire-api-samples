using CallfireApiClient;
using CallfireApiClient.Api.Common.Model;

public class ApiClientSample
{
    public static void Main(string[] args)
    {
        var client = new CallfireClient("api_login", "api_password");
        ResourceId resourceId = client.MediaApi.Upload("/path/to/file.mp3");
    }
}
