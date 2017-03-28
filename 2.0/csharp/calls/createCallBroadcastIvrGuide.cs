using System.Collections.Generic;
using CallfireApiClient;
using CallfireApiClient.Api.Campaigns.Model;
using CallfireApiClient.Api.Common.Model;

public class ApiClientSample
{
    public static void Main(string[] args)
    {
        var client = new CallfireClient("api_login", "api_password");
        var broadcast = new CallBroadcast
        {
            Name = "IVR Campaign",
            // set validated Caller ID number.
            FromNumber = "12135551189",
            // attach custom labels if needed
            Labels = new List<string> {"ivr tag", "id-10002"},
            // allow CallFire to dial recipient only between 09:00 - 18:00 depending on
            //  recipient's number area code timezone
            LocalTimeRestriction = new LocalTimeRestriction
            {
                BeginHour = 9,
                BeginMinute = 0,
                EndHour = 18,
                EndMinute = 0
            },
            // schedule a campaign to run on every Monday and Wednesday starting from 2016-12-01 10:00:00
            Schedules = new List<Schedule>
            {
                new Schedule
                {
                    StartDate = new LocalDate {Year = 2016, Month = 12, Day = 1},
                    StartTimeOfDay = new LocalTime {Hour = 10, Minute = 0, Second = 0},
                    // set weekly schedule
                    DaysOfWeek = new HashSet<DayOfWeek> {DayOfWeek.MONDAY, DayOfWeek.WEDNESDAY},
                    // set optional time zone, if leave empty account's timezone will be used
                    TimeZone = "America/New_York"
                }
            },
            // set retry configuration to attempt a contact's Mobile and Work phone numbers twice in case Call was
            //  resulted to BUSY or No Answer response. Set 5 minutes between attempts.
            RetryConfig = new RetryConfig
            {
                MaxAttempts = 2,
                MinutesBetweenAttempts = 5,
                RetryResults = new List<RetryResults> {RetryResults.BUSY, RetryResults.NO_ANS},
                RetryPhoneTypes = new List<RetryPhoneTypes>
                {
                    RetryPhoneTypes.MOBILE_PHONE,
                    RetryPhoneTypes.WORK_PHONE
                }
            },
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
                        <!-- play a text message -->
                        <play type=""tts"" voice=""female1"" name=""play_msg"">Hello, ${contact.firstName}, this is CallFire IVR message.</play>
                        <!-- user has pressed 1, repeat starting from menu entry -->
                        <keypress pressed=""1"">
                            <goto>live</goto>
                        </keypress>
                        <!-- nothing is pressed for a 3500 milliseconds, hang up the phone -->
                        <keypress pressed=""timeout"">
                            <hangup/>
                        </keypress>
                    </menu>
                    <hangup name=""hangup""/>
                </dialplan>
            "
        };

        // create broadcast with 'start' argument = true to start campaign immediately
        var id = client.CallBroadcastsApi.Create(broadcast, false);
    }
}

