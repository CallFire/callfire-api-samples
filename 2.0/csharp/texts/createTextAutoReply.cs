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
            Number = "19206596476",
            Message = "test message",
            Match = "test match"
        };
        ResourceId resourceId = client.TextAutoRepliesApi.Create(textAutoReply);
    }
}
