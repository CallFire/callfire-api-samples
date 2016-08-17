using System.Collections.Generic;
using CallfireApiClient;
using CallfireApiClient.Api.Campaigns.Model;

public class ApiClientSample
{
    public static void Main(string[] args)
    {
        var client = new CallfireClient("api_login", "api_password");
        var calls = client.CallBroadcastsApi.AddRecipients(1234, new List<Recipient>
        {
            new Recipient {PhoneNumber = "12131234567"},
            new Recipient {PhoneNumber = "12131234568"}
        });
    }
}
