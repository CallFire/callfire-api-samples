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
            FromNumber = "12135551189",
            // attach custom labels if needed
            Labels = new List<string> {"charity", "id-10002"},
            // allow CallFire to send out a message to recipient only between 09:00 - 18:00 depending on
            //  recipient's number area code timezone
            LocalTimeRestriction = new LocalTimeRestriction
            {
                BeginHour = 9,
                BeginMinute = 0,
                EndHour = 18,
                EndMinute = 0
            },

            // set message text
            Message = @"
                Hello ${u_name}. Missing for a great event ?
                We invite you to participate in a charity fair which takes place at first Saturday of November. You can order
                tickets by calling us: 855-555-5555. We are looking forward to meet you there
            ",
            // add new recipients
            Recipients = new List<TextRecipient>
            {
                new TextRecipient
                {
                    PhoneNumber = "12135551100",
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
                    PhoneNumber = "12135551101",
                    Attributes = new Dictionary<string, string>
                    {
                        {"u_name", "Mark"}
                    }
                },
                new TextRecipient
                {
                    PhoneNumber = "12135551101",
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
