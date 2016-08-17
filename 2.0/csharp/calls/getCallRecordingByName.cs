using CallfireApiClient;
using CallfireApiClient.Api.Campaigns.Model;

public class ApiClientSample
{
    public static void Main(string[] args)
    {
        var client = new CallfireClient("api_login", "api_password");
        CallRecording recording = client.CallsApi.GetCallRecordingByName(1234, "testName");
    }
}
