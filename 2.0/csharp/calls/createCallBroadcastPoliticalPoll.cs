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
            Name = "Political Campaign",
            // set validated Caller ID number.
            FromNumber = "12135551189",
            // attach custom labels if needed
            Labels = new List<string> {"political-poll", "id-10002"},
            // allow CallFire to dial recipient only between 09:00 - 18:00 depending on
            //  recipient's number area code timezone
            LocalTimeRestriction = new LocalTimeRestriction
            {
                BeginHour = 9,
                BeginMinute = 0,
                EndHour = 18,
                EndMinute = 0
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
                    <amd>
                        <live>
                            <goto name=""goto_Live"">Live</goto>
                        </live>
                        <machine>
                            <goto name=""goto_Machine"">Machine</goto>
                        </machine>
                    </amd>
                    <menu maxDigits=""1"" timeout=""3500"" name=""Live"">
                        <play type=""tts"" voice=""female1"" name=""play_Live"">Hello.
                        This is a call for a short political poll for the upcoming election.
                        Will you vote in the upcoming election?
                        Press 1 for Yes, or 2 for No..</play>
                        <keypress pressed=""1"" name=""kp_Vote"">
                            <stash varname=""Vote"" name=""stash_Will_Vote"">Yes</stash>
                            <goto>Question_01</goto>
                        </keypress>
                        <keypress pressed=""2"" name=""kp_Will_Not_Vote"">
                            <stash varname=""Vote"" name=""stash_Will_Not_Vote"">No</stash>
                            <play type=""tts"" voice=""female1"" name=""play_Goodbye_1"">Thank you for your time. Goodbye.</play>
                            <goto>Hangup</goto>
                        </keypress>
                        <keypress pressed=""default"" name=""incorrect_Selection"">
                            <play type=""tts"" voice=""female1"" name=""play_Inorrect_Selection"">That is not a valid selection. Please try again.</play>
                            <goto name=""replay_Live"">Live</goto>
                        </keypress>
                    </menu>
                    <menu maxDigits=""1"" timeout=""3500"" name=""Question_01"">
                        <play type=""tts"" voice=""female1"" name=""play_Question_01"">Who will you vote for in the upcoming elections?
                        Press 1 for Donkeys.
                        Press 2 for Elephants.
                        Press 3 for Greenies,
                        press 4 for Undecided,
                        or,
                        press 5 for Decline to state.</play>
                        <keypress pressed=""1-5"" name=""Selection_Question_01"">
                            <stash varname=""Candidate"" name=""stash_Candidate"">${call.lastinput}</stash>
                            <goto name=""goto_Goodbye"">Goodbye</goto>
                        </keypress>
                        <keypress pressed=""default"" name=""incorrect_Selection_Question_01"">
                            <play type=""tts"" voice=""female1"" name=""play_Inorrect_Selection_Question_01"">
                                That is not a valid selection. Please try again.
                            </play>
                            <goto name=""replay_Question_01"">Question_01</goto>
                        </keypress>
                    </menu>
                    <play type=""tts"" voice=""female1"" name=""Goodbye"">
                        Thank you for taking our poll. Please remember to vote in the upcoming election! Thank you for your time. Goodbye.
                    </play>
                    <goto name=""Goodbye_Hangup"">Hangup</goto>
                    <play type=""tts"" voice=""female1"" name=""Machine"">
                        Hello. This is a call for a political poll for the upcoming election.
                        Sorry we missed you. We will try you again later, or,
                         if you would like to take this short poll, please call 8 5 5,5 5 5,5 5 5 5. Thank you.</play>
                    <hangup name=""Hangup""/>
                </dialplan>
            "
        };

        // create broadcast with 'start' argument = true to start campaign immediately
        var id = client.CallBroadcastsApi.Create(broadcast, false);
    }
}

