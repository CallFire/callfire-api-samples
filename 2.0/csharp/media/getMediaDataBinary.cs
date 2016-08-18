import com.callfire.api.client.CallfireClient;
using System.IO;
using CallfireApiClient;
using CallfireApiClient.Api.CallsTexts.Model;

public class ApiClientSample
{
    public static void Main(string[] args)
    {
        var client = new CallfireClient("api_login", "api_password");
        Stream stream = client.MediaApi.GetData("450cffe3c128377a790df0059fb82fd6", MediaType.JPEG);
    }
}
