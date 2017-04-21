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
            Name = "Example API Call Broadcast",
            // set validated Caller ID number.
            FromNumber = "12135551189",
            // set answering machine detection
            AnsweringMachineConfig = AnsweringMachineConfig.AM_AND_LIVE,
            // set voice messages using TTS option for Live answers and when Answering Machine is detected.
            // you also can set a pre-defined TTS voice.
            Sounds = new CallBroadcastSounds
            {
                LiveSoundText = "Hello! This is a live answer text to speech recording",
                MachineSoundText = "This is an answering machine text to speech recording"
            },
            // add new recipients
            Recipients = new List<Recipient>
            {
                new Recipient
                {
                    PhoneNumber = "2134441133"
                },
                new Recipient
                {
                    PhoneNumber = "2135551144"
                }
            },
            ResumeNextDay = true
        };

        // create broadcast with 'start' argument = true to start campaign immediately
        var id = client.CallBroadcastsApi.Create(broadcast);
    }
}
