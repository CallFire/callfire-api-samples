using System.Collections.Generic;
using CallfireApiClient;
using CallfireApiClient.Api.Campaigns.Model;

public class ApiClientSample
{
    public static void Main(string[] args)
    {
        var client = new CallfireClient("api_login", "api_password");
        var calls = client.CallBroadcastsApi.AddRecipients(11646003, new List<Recipient>
        {
            new Recipient {PhoneNumber = "12135551122"},
            new Recipient {ContactId = 122460000043},
            new Recipient {PhoneNumber = "12135558090",
                           Attributes = new Dictionary<string, string>
                          {
                              {"custom_external_id", "30005044"},
                              {"custom_property_1", "value1"}
                          }
            }
        });
    }
}
