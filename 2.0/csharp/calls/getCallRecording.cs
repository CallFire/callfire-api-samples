using CallfireApiClient;
using CallfireApiClient.Api.Campaigns.Model;

public class ApiClientSample
{
    public static void Main(string[] args)
    {
        var client = new CallfireClient("api_login", "api_password");
        CallRecording rec = client.CallsApi.GetCallRecording(379506003, "callId,campaignId,lengthInBytes,mp3Url");
    }
}
