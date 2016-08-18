using System.Collections.Generic;
using CallfireApiClient;
using CallfireApiClient.Api.CallsTexts.Model;
using CallfireApiClient.Api.Campaigns.Model;

public class ApiClientSample
{
    public static void Main(string[] args)
    {
        var client = new CallfireClient("api_login", "api_password");
        var broadcast = new TextBroadcast
        {
            Name = "text_broadcast",
            FromNumber = "12131234567",
            BigMessageStrategy = BigMessageStrategy.SEND_MULTIPLE,
            Message = "test_msg",
            LocalTimeRestriction = new LocalTimeRestriction
            {
                BeginHour = 10,
                BeginMinute = 10,
                EndHour = 22,
                EndMinute = 0,
                Enabled = true
            },
            Recipients = new List<TextRecipient>
            {
                new TextRecipient {PhoneNumber = "12132212384"},
                new TextRecipient {PhoneNumber = "12132212385"}
            },
            ResumeNextDay = true
        };
        // create broadcast
        var id = client.TextBroadcastsApi.Create(broadcast, true);
    }
}
