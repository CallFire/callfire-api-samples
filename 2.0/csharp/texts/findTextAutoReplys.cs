using CallfireApiClient;
using CallfireApiClient.Api.Campaigns.Model;
using CallfireApiClient.Api.Campaigns.Model.Request;
using CallfireApiClient.Api.Common.Model;

public class ApiClientSample
{
    public static void Main(string[] args)
    {
        var client = new CallfireClient("api_login", "api_password");
        var request = new FindTextAutoRepliesRequest
        {
            Number = "12132000384",
            Offset = 0,
            Limit = 10,
            Fields = "items(id,match,keyword,message)"
        };
        Page<TextAutoReply> autoReplies = client.TextAutoRepliesApi.Find(request);
    }
}
