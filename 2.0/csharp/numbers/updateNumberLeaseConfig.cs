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
        NumberConfig config = new NumberConfig
        {
            Number = "19206596476",
            ConfigType = NumberConfig.NumberConfigType.TRACKING,
            CallTrackingConfig = callTrackingConfig
        };
        client.NumberLeasesApi.UpdateConfig(config);
    }
}

