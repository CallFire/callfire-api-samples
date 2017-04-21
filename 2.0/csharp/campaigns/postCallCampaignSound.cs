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
            Name = "Sound 1",
            ToNumber = "12135551122"
        };
        ResourceId resourceId = client.CampaignSoundsApi.RecordViaPhone(callCreateSound);
    }
}
