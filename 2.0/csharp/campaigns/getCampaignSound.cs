using CallfireApiClient;
using CallfireApiClient.Api.Campaigns.Model;

public class ApiClientSample
{
    public static void Main(string[] args)
    {
        var client = new CallfireClient("api_login", "api_password");
        // limit returned fields if needed, e.g. "name,status,lengthInSeconds"
        CampaignSound campaignSound = client.CampaignSoundsApi.Get(379506003, "name,lengthInSeconds");
    }
}
