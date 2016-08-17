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
            Name = "call_broadcast",
            AnsweringMachineConfig = AnsweringMachineConfig.AM_AND_LIVE,
            Sounds = new CallBroadcastSounds
            {
                LiveSoundText = "Hello! This is a live answer text to speech recording",
                LiveSoundTextVoice = Voice.MALE1,
                MachineSoundText = "This is an answering machine text to speech recording",
                MachineSoundTextVoice = Voice.MALE1
            },
            Recipients = new List<Recipient>
            {
                new Recipient {PhoneNumber = "12132212384"},
                new Recipient {PhoneNumber = "12132212385"}
            },
            ResumeNextDay = true
        };

        // create broadcast with 'start' argument = true to start campaign immediately
        var id = client.CallBroadcastsApi.Create(broadcast, true);
    }
}
