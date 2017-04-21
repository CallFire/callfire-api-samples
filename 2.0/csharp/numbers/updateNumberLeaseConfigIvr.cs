using CallfireApiClient;
using CallfireApiClient.Api.Numbers.Model;

public class ApiClientSample
{
    public static void Main(string[] args)
    {
        var client = new CallfireClient("api_login", "api_password");
        // create new IVR config
        var config = new NumberConfig
        {
            Number = "19206596476",
            ConfigType = NumberConfig.NumberConfigType.IVR,
            IvrInboundConfig = new IvrInboundConfig
            {
                DialplanXml = @"
                    <dialplan name=""Root"">
                        <menu maxDigits=""1"" timeout=""3500"" name=""Live"">
                            <play type=""tts"" voice=""female1"">
                                Hello this is AB Advertising, please press 1 to transfer to our sales representative, 
                                press 2 to contact clients support.
                            </play>
                            <keypress pressed=""1"">
                                 <!-- user pressed 1, store this data in 'selected_menu' variable -->
                                <stash varname=""selected_menu"">sales</stash>
                                <play type=""tts"" voice=""female1"">
                                    You will be transferred to sales representative in a moment. Please wait.
                                </play>
                                <transfer callerid=""${call.callerid}"" musiconhold=""blues"" mode=""ringall"">
                                    15550004455
                                </transfer>
                            </keypress>
                            <keypress pressed=""2"" name=""kp_become_volonteer"">
                                 <!-- user pressed 2, store this data in 'selected_menu' variable -->
                                <stash varname=""selected_menu"">support</stash>
                                <play type=""tts"" voice=""female1"">
                                    You will be transferred to clients support. Please wait.
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
                        <play type=""tts"" voice=""female1"">
                            Thank you for calling us. Have a good day.
                        </play>
                        <hangup name=""Hangup""/>
                    </dialplan>
                "
            }
        };
        client.NumberLeasesApi.UpdateConfig(config);
    }
}
