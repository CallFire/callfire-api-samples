using System.Collections.Generic;
using CallfireApiClient;
using CallfireApiClient.Api.CallsTexts.Model;
using CallfireApiClient.Api.Campaigns.Model;
using CallfireApiClient.Api.Campaigns.Model.Request;

public class ApiClientSample
{
    public static void Main(string[] args)
    {
        var client = new CallfireClient("api_login", "api_password");
        var request = new AddBatchRequest
        {
            CampaignId = 11646003,
            Name = "contact batch for text",
            Recipients = new List<Recipient>
            {
               new TextRecipient {PhoneNumber = "12135551122"},
               new TextRecipient {PhoneNumber = "12135553434"},
               new TextRecipient
               {
                   PhoneNumber = "12135558090",
                   Attributes = new Dictionary<string, string>
                   {
                       {"custom_external_id", "30005044"},
                       {"custom_property_1", "value1"}
                   }
               }
            },
            //or you can add contacts from particular contact list
            //ContactListId = 70055003
            ScrubDuplicates = true
        };
        var resourceId = client.TextBroadcastsApi.AddBatch(request);
    }
}
