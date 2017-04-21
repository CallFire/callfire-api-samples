using System.Collections.Generic;
using CallfireApiClient;
using CallfireApiClient.Api.CallsTexts.Model;
using CallfireApiClient.Api.Common.Model.Request;
using CallfireApiClient.Api.Campaigns.Model;

public class ApiClientSample
{
    public static void Main(string[] args)
    {
        var client = new CallfireClient("api_login", "api_password");

        var request = new SendCallsRequest()
        {
            DefaultVoice = Voice.MALE1,
            Fields = "items(id,state,toNumber)",
            CampaignId = 4050600003,
            Recipients = new List<CallRecipient>
            {
                new CallRecipient
                {
                    PhoneNumber = "12135551100",
                    LiveMessage = "Hello, Alice, this is message for live answer",
                    MachineMessage = "Hello, Alice, this is message for answering machine"
                },
                new CallRecipient
                {
                    PhoneNumber = "12135551101",
                    LiveMessage = "Hello, Bob, this is message for live answer",
                    MachineMessage = "Hello, Bob, this is message for answering machine"
                }
            }
        };
       
        IList<Call> calls = client.CallsApi.Send(request);
    }
}
