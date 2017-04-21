using CallfireApiClient;
using CallfireApiClient.Api.CallsTexts.Model.Request;
using CallfireApiClient.Api.Campaigns.Model;
using CallfireApiClient.Api.Common.Model;

public class ApiClientSample
{
    public static void Main(string[] args)
    {
        var client = new CallfireClient("api_login", "api_password");
        FindSoundsRequest request = new FindSoundsRequest
        {
            Filter = "name",
            IncludeArchived = true,
            IncludePending = true,
            IncludeScrubbed = true,
            Offset = 0,
            Limit = 10,
            Fields = "items(id,name,callback)"
        };
        Page<CampaignSound> campaignSounds = client.CampaignSoundsApi.Find(request);
    }
}
