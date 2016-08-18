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
            CampaignId = 123456,
            Name = "new_batch",
            Recipients = new List<Recipient>
            {
                new TextRecipient {PhoneNumber = "12132212384"},
                new TextRecipient {PhoneNumber = "12132212385"}
            }
        };
        var resourceId = client.TextBroadcastsApi.AddBatch(request);
    }
}
