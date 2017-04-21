using CallfireApiClient;
using CallfireApiClient.Api.Campaigns.Model;
using CallfireApiClient.Api.Common.Model;

public class ApiClientSample
{
    public static void Main(string[] args)
    {
        var client = new CallfireClient("api_login", "api_password");
        var tts = new TextToSpeech
        {
            Message = "This is a TTS sound",
            Voice = Voice.MALE1
        };
        ResourceId resourceId = client.CampaignSoundsApi.CreateFromTts(tts);
    }
}
