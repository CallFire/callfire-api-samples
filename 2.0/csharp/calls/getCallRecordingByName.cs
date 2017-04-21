using CallfireApiClient;
using CallfireApiClient.Api.Campaigns.Model;

public class ApiClientSample
{
    public static void Main(string[] args)
    {
        var client = new CallfireClient("api_login", "api_password");
        CallRecording recording = client.CallsApi.GetCallRecordingByName(379506003, "call-recording1", "callId,campaignId,lengthInBytes,mp3Url");
    }
}
