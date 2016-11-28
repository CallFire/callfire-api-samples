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
            PhoneNumber = "12135551100",
            LiveMessage = "Hello, Alice, this is message for live answer",
            MachineMessage = "Hello, Alice, this is message for answering machine"
        };
        var recipient2 = new CallRecipient
        {
            PhoneNumber = "12135551101",
            LiveMessage = "Hello, Bob, this is message for live answer",
            MachineMessage = "Hello, Bob, this is message for answering machine"
        };
        var recipients = new List<CallRecipient> {recipient1, recipient2};
        IList<Call> calls = client.CallsApi.Send(recipients);
    }
}
