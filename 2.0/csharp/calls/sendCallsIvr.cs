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
            // set IVR XML
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
        };
        var recipients = new List<CallRecipient> {recipient1};
        IList<Call> calls = client.CallsApi.Send(recipients);
    }
}
