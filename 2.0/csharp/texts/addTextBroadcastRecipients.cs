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
            new TextRecipient {PhoneNumber = "12135551122"},
            new TextRecipient {ContactId = 122460000043},
            new TextRecipient
            {
                PhoneNumber = "12135558090",
                Attributes = new Dictionary<string, string>
                {
                    {"custom_external_id", "30005044"},
                    {"custom_property_1", "value1"}
                }
            },
        };
        var texts = client.TextBroadcastsApi.AddRecipients(11646003, recipients);
    }
}
