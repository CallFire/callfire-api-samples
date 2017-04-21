using System.Collections.Generic;
using CallfireApiClient;
using CallfireApiClient.Api.CallsTexts.Model;
using CallfireApiClient.Api.Common.Model.Request;

public class ApiClientSample
{
    public static void Main(string[] args)
    {
        var client = new CallfireClient("api_login", "api_password");
        var recipient1 = new TextRecipient
        {
            Message = "Hello World!",
            PhoneNumber = "12135551122"
        };
        var recipient2 = new TextRecipient
        {
            ContactId = 122460000043
        };
        var recipient3 = new TextRecipient
        {
            PhoneNumber = "12135558090",
            Attributes = new Dictionary<string, string>
            {
                {"custom_external_id", "30005044"},
                {"custom_name", "Alice"}
            },
            Message = "Hello, ${custom_name}!"
        };
        var recipients = new List<TextRecipient> {recipient1, recipient2, recipient3};
        var request = new SendTextsRequest
        {
            Recipients = recipients,
            CampaignId = 4050600003,
            DefaultMessage = "Hello!"
        };
        IList<Text> texts = client.TextsApi.Send(request);
    }
}
