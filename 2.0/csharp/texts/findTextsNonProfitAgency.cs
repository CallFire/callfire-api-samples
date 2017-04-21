using CallfireApiClient;
using CallfireApiClient.Api.CallsTexts.Model;
using CallfireApiClient.Api.CallsTexts.Model.Request;
using CallfireApiClient.Api.Common.Model;

public class ApiClientSample
{
    public static void Main(string[] args)
    {
        var client = new CallfireClient("api_login", "api_password");
        var request = new FindTextsRequest
        {
            // find all replies for a particular Text Broadcast
            CampaignId = 1003003,
            Inbound = true,
            Limit = 10
        };
        Page<Text> texts = client.TextsApi.Find(request);
    }
}
