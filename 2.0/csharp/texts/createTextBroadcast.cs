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
            Name = "Charity Campaign",
            // set validated Caller ID number.
            FromNumber = "19206596476",
            // attach custom labels if needed
            Labels = new List<string> {"charity", "id-10003"},
            // set message text
            Message = @"Hello {u_name} ...",
            // add new recipients
            Recipients = new List<TextRecipient>
            {
                new TextRecipient
                {
                    PhoneNumber = "13233834422",
                    // set custom recipient attributes, they are available only to a single Call/Text
                    //  action, do not confuse them with contact fields which are stored with contact
                    //  and are available to each Call/Text where contact is attached to
                    Attributes = new Dictionary<string, string>
                    {
                        {"u_name", "Alice"},
                        {"age", "30"}
                    }
                },
                new TextRecipient
                {
                    PhoneNumber = "13233834433",
                    Attributes = new Dictionary<string, string>
                    {
                        {"u_name", "Mark"},
                        {"age", "45"}
                    }
                },
                new TextRecipient
                {
                    PhoneNumber = "13233834488",
                    // you can override a message set in broadcast for a particular recipient
                    Message = "Hi ${u_name}, the megic number is ${magic_number}",
                    Attributes = new Dictionary<string, string>
                    {
                        {"u_name", "Jane"},
                        {"magic_number", "10"}
                    }
                }
            }
        };

        // create broadcast with 'start' argument = true to start campaign immediately
        var id = client.TextBroadcastsApi.Create(broadcast, true);
    }
}
