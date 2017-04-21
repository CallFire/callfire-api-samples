using System.Collections.Generic;
using CallfireApiClient;
using CallfireApiClient.Api.Campaigns.Model;

public class ApiClientSample
{
    public static void Main(string[] args)
    {
        var client = new CallfireClient("api_login", "api_password");
        // limit returned fields if needed
        IList<CallRecording> recordings = client.CallsApi.GetCallRecordings(379506003, "items(callId,campaignId,lengthInBytes,mp3Url)");
    }
}
