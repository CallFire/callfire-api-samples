using System.Collections.Generic;
using CallfireApiClient;
using CallfireApiClient.Api.Campaigns.Model;
using CallfireApiClient.Api.Common.Model;

public class ApiClientSample
{
    public static void Main(string[] args)
    {
        var client = new CallfireClient("api_login", "api_password");
        var broadcast = new CallBroadcast()
        {
            Id = 11646003,
            Name = "Call Broadcast with Schedules",
            AnsweringMachineConfig = AnsweringMachineConfig.LIVE_IMMEDIATE,
            Sounds = new CallBroadcastSounds()
            {
                LiveSoundText = "Hello! This is an updated Call Broadcast config tts"
            },
            Schedules = new List<Schedule>()
            {
                new Schedule
                {
                    StartDate = new LocalDate { Year = 2016, Month = 12, Day = 1 },
                    StartTimeOfDay = new LocalTime { Hour = 10, Minute = 0, Second = 0 },
                    StopDate = new LocalDate { Year = 2016, Month = 12, Day = 10 },
                    StopTimeOfDay = new LocalTime { Hour = 18, Minute = 0, Second = 0 },
                    // set weekly schedule
                    DaysOfWeek = new HashSet<DayOfWeek> { DayOfWeek.SATURDAY, DayOfWeek.SUNDAY },
                    // set optional time zone, if leave empty account's timezone will be used
                    TimeZone = "America/New_York"
                }
            }
        };
      
        // update campaign
        client.CallBroadcastsApi.Update(broadcast);
    }
}
