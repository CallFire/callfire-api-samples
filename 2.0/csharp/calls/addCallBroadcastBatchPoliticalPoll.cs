using CallfireApiClient;
using CallfireApiClient.Api.Campaigns.Model.Request;

public class ApiClientSample
{
    public static void Main(string[] args)
    {
        var client = new CallfireClient("api_login", "api_password");
        var request = new AddBatchRequest
        {
            // your existing campaign id, you can get it via find() operation
            CampaignId = 11646003,
            Name = "Contacts Batch 1",
            // id of contact list that you have added on previous step
            ContactListId = 300555001,
            ScrubDuplicates = true
        };
        var id = client.CallBroadcastsApi.AddBatch(request);
    }
}
