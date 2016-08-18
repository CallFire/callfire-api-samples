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
            Message = "msg 1",
            PhoneNumber = "12132212384"
        };
        var recipient2 = new TextRecipient
        {
            Message = "msg 2",
            PhoneNumber = "12132212399"
        };
        IList<Text> texts = client.TextsApi.Send(new List<TextRecipient> {recipient1, recipient2});

        // in case you have multiple recipients with the same text you can use defaultMessage param to specify 
        // text once for all recipients
        //
        // var recipient1 = new TextRecipient { Message = "msg", PhoneNumber = "12132212384" };
        // var recipient2 = new TextRecipient { Message = "msg", PhoneNumber = "12132212384" };
        // var recipients = new List<TextRecipient> { recipient1, recipient2 };
        // var request = new SendTextsRequest
        // {
        //    Recipients = recipients,
        //    CampaignId = 7415135003,
        //    DefaultMessage = "Hello!",
        //    // limit returned fields if needed
        //    Fields = "items(id,fromNumber,state)"
        // };
        // IList<Text> texts = Client.TextsApi.Send(request);
    }
}
