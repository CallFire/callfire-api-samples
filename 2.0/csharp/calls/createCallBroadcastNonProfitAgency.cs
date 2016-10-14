using System.Collections.Generic;
using CallfireApiClient;
using CallfireApiClient.Api.Campaigns.Model;
using DayOfWeek = CallfireApiClient.Api.Campaigns.Model.DayOfWeek;

public class ApiClientSample
{
    public static void Main(string[] args)
    {
        var client = new CallfireClient("api_login", "api_password");
        var broadcast = new CallBroadcast
        {
            Name = "Charity Campaign",
            // set validated Caller ID number.
            FromNumber = "12135551189",
            // attach custom labels if needed
            Labels = new List<string> {"charity", "id-10002"},
            // set answering machine detection
            AnsweringMachineConfig = AnsweringMachineConfig.AM_AND_LIVE,
            // set voice messages using TTS option for Live answers and when Answering Machine is detected.
            // you also can set a pre-defined TTS voice.
            Sounds = new CallBroadcastSounds
            {
                LiveSoundText = "Hello, this is Mary, from the local branch of Non-profit agency. " +
                                "Do not miss our charity weekend taking place at first November weekends." +
                                " We are looking forward to meet you there. Press '1' to to find out more details.",
                LiveSoundTextVoice = Voice.MALE1,
                MachineSoundText = "Hello, this is Mary, from the local branch of Non-profit agency. " +
                                   "If you are interested in charity weekend, please call (231) 455-7676.",
                MachineSoundTextVoice = Voice.MALE1,
                TransferSoundText = "Please wait a moment, call is being transfer.",
                // set number to transfer call to once transfer digit is pressed
                TransferDigit = "1",
                TransferNumber = "12314557676"
            },
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
            // add new recipients
            Recipients = new List<Recipient>
            {
                new Recipient
                {
                    PhoneNumber = "12135551100",
                    // set custom recipient attributes, they are available only to a single Call/Text
                    //  action, do not confuse them with contact fields which are stored with contact
                    //  and are available to each Call/Text where contact is attached to
                    Attributes = new Dictionary<string, string>
                    {
                        {"age", "30"},
                        {"position", "Manager"}
                    }
                },
                new Recipient
                {
                    PhoneNumber = "12135551101",
                    Attributes = new Dictionary<string, string>
                    {
                        {"external_system_id", "34347770001"},
                        {"call_label", "friends"}
                    }
                },
                // You can use already existing contacts as a recipients
                new Recipient
                {
                    ContactId = 46000044001
                }
            }
        };

        // create broadcast with 'start' argument = true to start campaign immediately
        var id = client.CallBroadcastsApi.Create(broadcast, false);
    }
}

