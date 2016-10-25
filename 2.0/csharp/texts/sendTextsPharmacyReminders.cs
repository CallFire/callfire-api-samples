using System.Collections.Generic;
using CallfireApiClient;
using CallfireApiClient.Api.CallsTexts.Model;

public class ApiClientSample
{
    public static void Main(string[] args)
    {
        var client = new CallfireClient("api_login", "api_password");
        var recipient1 = new TextRecipient
        {
            Message = "Hello ${contact_name}, you have an appointment with Dr. Andrew "
                      + "tomorrow at 3:00 PM, if you need to reschedule please call (855)-555-4477",
            PhoneNumber = "12135551123",
            // set custom recipient attributes, they are available only to a single Call/Text
            //  action, do not confuse them with contact fields which are stored with contact
            //  and are available to each Call/Text where contact is attached to
            Attributes = new Dictionary<string, string>
            {
                {"contact_name", "Alice"},
                {"external_user_id", "45450007002"}
            }
        };
        IList<Text> texts = client.TextsApi.Send(new List<TextRecipient> {recipient1});
    }
}
