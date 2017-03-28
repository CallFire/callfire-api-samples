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
            Name = "Charity Campaign",
            // set validated Caller ID number.
            FromNumber = "12135551189",
            // attach custom labels if needed
            Labels = new List<string> {"charity", "id-10002"},
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
                            <goto name=""goto_Live"">Live</goto>
                        </live>
                        <machine>
                            <goto name=""goto_Machine"">Machine</goto>
                        </machine>
                    </amd>
                    <menu maxDigits=""1"" timeout=""3500"" name=""Live"">
                        <play type=""tts"" voice=""female1"" name=""play_Live"">
                            Hello ${contact.firstName}, we are organizing a charity weekend in November.
                            Don't miss to visit it. Press ""1"" to follow the instructions how to order the 
                            tickets, press ""2"" if you are willing to become a volunteer at event.
                        </play>
                        <keypress pressed=""1"" name=""kp_order_tickets"">
                             <!-- store recipient's answer and go to another menu to make a purchase -->
                            <stash varname=""order"" name=""create_an_order"">Yes</stash>
                            <goto>order_tickets</goto>
                        </keypress>
                        <keypress pressed=""2"" name=""kp_become_volonteer"">
                            <!-- store recipient's answer -->
                            <stash varname=""volonteer"" name=""become_volonteer"">Yes</stash>
                            <play type=""tts"" voice=""female1"" name=""play_Goodbye_1"">
                                Thanks for the response. We will call you later today.
                            </play>
                            <goto>Hangup</goto>
                        </keypress>
                         <!-- if pressed key is not specified in menu replay Live menu -->
                        <keypress pressed=""default"" name=""incorrect_Selection"">
                            <play type=""tts"" voice=""female1"" name=""play_Inorrect_Selection"">
                                That is not a valid selection. Please try again.
                            </play>
                            <goto name=""replay_Live"">Live</goto>
                        </keypress>
                    </menu>
                    <menu maxDigits=""1"" timeout=""3500"" name=""order_tickets"">
                        <play type=""tts"" voice=""female1"" name=""play_order_tickets"">
                            You will be transferred to Sales representative in a moment. Please wait.
                        </play>
                        <transfer callerid=""${call.callerid}"" musiconhold=""blues"" mode=""ringall"">
                            15551234567
                        </transfer>
                    </menu>
                    <play type=""tts"" voice=""female1"" name=""Goodbye"">
                        Thank you for taking our survey
                    </play>
                    <goto name=""Goodbye_Hangup"">Hangup</goto>
                    <play type=""tts"" voice=""female1"" name=""Machine"">
                        Hello ${contact.firstName} ${contact.lastName}. 
                        We are organizing a charity weekend in November.
                        If you would like to participate, please call 8 5 5, 5 5 5, 5 5 5 5. 
                        Thank you.
                    </play>
                    <hangup name=""Hangup""/>
                </dialplan>
            ",
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

