using CallfireApiClient;
using CallfireApiClient.Api.Campaigns.Model;
using CallfireApiClient.Api.Common.Model;

public class ApiClientSample
{
    public static void Main(string[] args)
    {
        var client = new CallfireClient("api_login", "api_password");
        var textAutoReply = new TextAutoReply()
        {
            Number = "67076",
            Message = "I am a leaf on the wind",
            Keyword = "CALLFIRE"
        };
        ResourceId resourceId = client.TextAutoRepliesApi.Create(textAutoReply);
    }
}
