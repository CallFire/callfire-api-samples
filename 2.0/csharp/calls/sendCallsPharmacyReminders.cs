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
            Attributes = new Dictionary<string, string>
            {
                {"external_user_id", "45450007002"}
            },
            DialplanXml = @"
                <dialplan name=""Root"">
                    <menu maxDigits=""1"" timeout=""3500"" name=""Live"">
                        <play type=""tts"" voice=""female1"">
                            Hello, this is UMM Health Center, you have an appointment with Dr. Andrew
                            tomorrow at 3:00 PM, please press 1 to confirm the time or press 2 to reschedule
                            appointment.
                        </play>
                        <keypress pressed=""1"">
                             <!-- user pressed 1, store this data in 'selected_menu' variable -->
                            <stash varname=""selected_menu"">confirmed</stash>
                            <goto>bye_tts</goto>
                        </keypress>
                        <keypress pressed=""2"">
                             <!-- user pressed 2, store this data in 'selected_menu' variable -->
                            <stash varname=""selected_menu"">reschedule</stash>
                            <play type=""tts"" voice=""female1"">
                                You will be transferred to our representative to reschedule an appointment. Please wait.
                            </play>
                            <transfer callerid=""${call.callerid}"" musiconhold=""blues"" mode=""ringall"">
                                15550005500
                            </transfer>
                        </keypress>
                         <!-- if pressed key is not specified in menu replay Live menu -->
                        <keypress pressed=""default"" name=""incorrect_Selection"">
                            <play type=""tts"" voice=""female1"">That is not a valid selection. Please try again.</play>
                            <goto name=""replay_Live"">Live</goto>
                        </keypress>
                    </menu>
                    <play type=""tts"" voice=""female1"" name=""bye_tts"">
                        Thank you for your response. Have a good day.
                    </play>
                    <hangup name=""Hangup""/>
                </dialplan>
            "
        };
        IList<Call> calls = client.CallsApi.Send(new List<CallRecipient> {recipient1});
    }
}
