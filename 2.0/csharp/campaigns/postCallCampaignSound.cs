using CallfireApiClient;
using CallfireApiClient.Api.Campaigns.Model;
using CallfireApiClient.Api.Common.Model;

public class ApiClientSample
{
    public static void Main(string[] args)
    {
        var client = new CallfireClient("api_login", "api_password");
        var callCreateSound = new CallCreateSound
        {
            Name = "call_in_sound",
            ToNumber = "12132212384"
        };
        ResourceId resourceId = client.CampaignSoundsApi.RecordViaPhone(callCreateSound);
    }
}
