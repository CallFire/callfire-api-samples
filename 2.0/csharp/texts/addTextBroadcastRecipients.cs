using System.Collections.Generic;
using CallfireApiClient;
using CallfireApiClient.Api.CallsTexts.Model;

public class ApiClientSample
{
    public static void Main(string[] args)
    {
        var client = new CallfireClient("api_login", "api_password");
        var recipients = new List<TextRecipient>
        {
            new TextRecipient {PhoneNumber = "12132212384"},
            new TextRecipient {PhoneNumber = "12132212385"}
        };
        var texts = client.TextBroadcastsApi.AddRecipients(123456, recipients);
    }
}
