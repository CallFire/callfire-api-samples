using System.Collections.Generic;
using CallfireApiClient;
using CallfireApiClient.Api.CallsTexts.Model;
using CallfireApiClient.Api.Common.Model.Request;

public class ApiClientSample
{
    public static void Main(string[] args)
    {
        var client = new CallfireClient("api_login", "api_password");

        var request = new SendCallsRequest()
        {
            Recipients = new List<CallRecipient> {
                new CallRecipient {
                    PhoneNumber = "12135551100",
                    Attributes = new Dictionary<string, string> {
                        {"external_user_id", "45450007002"}
                    },
                    DialplanXml = @"
                        <dialplan name=""Root"">
                            <!-- answering machine detection -->
                            <amd>
                                <!-- if call is answered by human go to live menu -->
                                <live>
                                    <goto>live</goto>
                                </live>
                                <!-- hangup if answering machine detected -->
                                <machine>
                                    <goto>hangup</goto>
                                </machine>
                            </amd>
                            <menu maxDigits=""1"" timeout=""3500"" name=""live"">
                                <!-- play text message with secure code -->
                                <play type=""tts"" voice=""female1"" name=""play_code"">Hello, ${contact.firstName}, this is CallFire IVR message.</play>
                                <keypress pressed=""1"">
                                    <goto>live</goto>
                                </keypress>
                                <keypress pressed=""timeout"">
                                    <hangup/>
                                </keypress>
                            </menu>
                            <hangup name=""hangup""/>
                        </dialplan>
                    "
                }
            }
        };

        IList<Call> calls = client.CallsApi.Send(request);
    }
}
