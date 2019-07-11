using System.Collections.Generic;
using CallfireApiClient;
using CallfireApiClient.Api.Numbers.Model;
using CallfireApiClient.Api.Common.Model;

public class ApiClientSample
{
    public static void Main(string[] args)
    {
        var client = new CallfireClient("api_login", "api_password");
        // create new call tracking config
        var callTrackingConfig = new CallTrackingConfig
        {
            Screen = false,
            Recorded = true,
            Voicemail = true,
            IntroSoundId = 10004001,
            WhisperSoundId = 10005002,
            VoicemailSoundId = 10006003,
            FailedTransferSoundId = 10007004,
            TransferNumbers = new List<string> {"12135551122", "12135551189"},
            WeeklySchedule = new WeeklySchedule()
            {
                StartTimeOfDay = new LocalTime { Hour = 10, Minute = 0, Second = 0 },
                StopTimeOfDay = new LocalTime { Hour = 18, Minute = 0, Second = 0 },
                DaysOfWeek = new HashSet<DayOfWeek> { DayOfWeek.MONDAY, DayOfWeek.TUESDAY, DayOfWeek.WEDNESDAY, DayOfWeek.THURSDAY, DayOfWeek.FRIDAY },
                TimeZone = "America/New_York"
            },
            GoogleAnalytics = new GoogleAnalytics ()
            {
                Domain = "domain - name",
                GoogleAccountId = "UA - XXXXX - 2X",
                Category = "Sales"
            }
        };

        // OR create IVR config
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
        };

        NumberConfig config = new NumberConfig
        {
            Number = "19206596476",
            // depends on what type of configuration your need assign TRACKING or IVR config
            ConfigType = NumberConfig.NumberConfigType.TRACKING,
            CallTrackingConfig = callTrackingConfig
            // ConfigType = NumberConfig.NumberConfigType.IVR,
            // CallTrackingConfig = IvrInboundConfig
        };
        client.NumberLeasesApi.UpdateConfig(config);
    }
}

