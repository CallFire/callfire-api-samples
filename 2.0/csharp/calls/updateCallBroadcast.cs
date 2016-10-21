using System.Collections.Generic;
using CallfireApiClient;
using CallfireApiClient.Api.Campaigns.Model;

public class ApiClientSample
{
    public static void Main(string[] args)
    {
        var client = new CallfireClient("api_login", "api_password");
        var broadcast = client.CallBroadcastsApi.Get(123L);
        // time restrictions
        broadcast.LocalTimeRestriction = new LocalTimeRestriction
        {
            BeginHour = 10,
            BeginMinute = 10,
            EndHour = 22,
            EndMinute = 0,
            Enabled = true
        };
        broadcast.Schedules.Add(
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
            });
        // update campaign
        client.CallBroadcastsApi.Update(broadcast);
    }
}
