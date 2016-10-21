using System.Collections.Generic;
using System.Collections.Generic;
using CallfireApiClient;
using CallfireApiClient.Api.Campaigns.Model;
using CallfireApiClient.Api.Campaigns.Model.Request;

public class ApiClientSample
{
    public static void Main(string[] args)
    {
        var client = new CallfireClient("api_login", "api_password");
        var request = new AddBatchRequest
        {
            CampaignId = 1234,
            Name = "Contact Batch 1",
            Recipients = new List<Recipient>
            {
                new Recipient {PhoneNumber = "12131234567"},
                new Recipient {PhoneNumber = "12131234568"}
            }
        };
        var id = client.CallBroadcastsApi.AddBatch(request);
    }
}
