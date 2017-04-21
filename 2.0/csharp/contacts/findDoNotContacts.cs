using CallfireApiClient;
using CallfireApiClient.Api.Common.Model;
using CallfireApiClient.Api.Contacts.Model;
using CallfireApiClient.Api.Contacts.Model.Request;
using System.Collections.Generic;

public class ApiClientSample
{
    public static void Main(string[] args)
    {
        var client = new CallfireClient("api_login", "api_password");
        var request = new FindDncNumbersRequest()
        {
            Prefix = "1424",
            Numbers = new List<string> { "12135551126", "12136666123" },
            CampaignId = 11646003,
            Source = "my source",
            Call = true,
            Text = true,
            Offset = 0,
            Limit = 10,
            Fields = "items(number,call)"
        };
        Page<DoNotContact> dncs = client.DncApi.Find(request);
    }
}
