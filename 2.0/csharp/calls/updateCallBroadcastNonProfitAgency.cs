using System.Collections.Generic;
using CallfireApiClient;
using CallfireApiClient.Api.Campaigns.Model;

public class ApiClientSample
{
    public static void Main(string[] args)
    {
        var client = new CallfireClient("api_login", "api_password");
        var broadcast = new CallBroadcast
        {
            Id = 11646003,
            Schedules = new List<Schedule>
            {
                // schedule a campaign to run on Saturday and Sunday between 2016-12-01 10:00:00
                //  and 2016-12-10 18:00:00
                new Schedule
                {
                    StartDate = new LocalDate {Year = 2016, Month = 12, Day = 1},
                    StartTimeOfDay = new LocalTime {Hour = 10, Minute = 0, Second = 0},
                    StopDate = new LocalDate {Year = 2016, Month = 12, Day = 10},
                    StopTimeOfDay = new LocalTime {Hour = 18, Minute = 0, Second = 0},
                    // set weekly schedule
                    DaysOfWeek = new HashSet<DayOfWeek> {DayOfWeek.SATURDAY, DayOfWeek.SUNDAY},
                    // set optional time zone, if leave empty account's timezone will be used
                    TimeZone = "America/New_York"
                },
                // add another schedule for campaign to start on Saturday and Sunday between 2016-12-20 10:00:00
                //  and 2016-12-30 18:00:00
                new Schedule
                {
                    StartDate = new LocalDate {Year = 2016, Month = 12, Day = 20},
                    StartTimeOfDay = new LocalTime {Hour = 10, Minute = 0, Second = 0},
                    StopDate = new LocalDate {Year = 2016, Month = 12, Day = 30},
                    StopTimeOfDay = new LocalTime {Hour = 18, Minute = 0, Second = 0},
                    // set weekly schedule
                    DaysOfWeek = new HashSet<DayOfWeek> {DayOfWeek.SATURDAY, DayOfWeek.SUNDAY}
                }
            }
        };

        // update broadcast with new schedules
        client.CallBroadcastsApi.Update(broadcast);
    }
}

