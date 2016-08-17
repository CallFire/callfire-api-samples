using System.Collections.Generic;
using CallfireApiClient;
using CallfireApiClient.Api.CallsTexts.Model;

public class ApiClientSample
{
    public static void Main(string[] args)
    {
        var client = new CallfireClient("api_login", "api_password");
        var recipient1 = new CallRecipient
        {
            ContactId = 463633187003,
            LiveMessage = "testMessage",
            TransferDigit = "1",
            TransferMessage = "transferTestMessage",
            TransferNumber = "14246525473"
        };
        var recipient2 = new CallRecipient
        {
            ContactId = 463633187003,
            LiveMessage = "test Message2",
            TransferDigit = "1",
            TransferMessageSoundId = 1,
            TransferNumber = "14246525473"
        };
        var recipients = new List<CallRecipient> {recipient1, recipient2};
        IList<Call> calls = client.CallsApi.Send(recipients);
    }
}
