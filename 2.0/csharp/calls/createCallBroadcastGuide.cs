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
            Name = "Call Broadcast",
            // set validated Caller ID number.
            FromNumber = "12135551189",
            // attach custom labels if needed
            Labels = new List<string> { "voice tag", "id-10002" },
            // set answering machine detection
            AnsweringMachineConfig = AnsweringMachineConfig.AM_AND_LIVE,
            // set voice messages using TTS option for Live answers and when Answering Machine is detected.
            Sounds = new CallBroadcastSounds
            {
                LiveSoundText = "Hello! This is a live answer text to speech recording",
                MachineSoundText = "This is an answering machine text to speech recording",
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
                RetryResults = new List<RetryResults> { RetryResults.BUSY, RetryResults.NO_ANS },
                RetryPhoneTypes = new List<RetryPhoneTypes>
                {
                    RetryPhoneTypes.MOBILE_PHONE,
                    RetryPhoneTypes.WORK_PHONE
                }
            }
        };

        // create broadcast with 'start' argument = true to start campaign immediately
        var id = client.CallBroadcastsApi.Create(broadcast);
    }
}
