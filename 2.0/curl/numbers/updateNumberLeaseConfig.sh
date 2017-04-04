#!/usr/bin/env bash

curl -u "username:password" -H "Content-Type:application/json" -X PUT -d '
    {
        "configType":"TRACKING",
        "callTrackingConfig":
        {
            "screen":"false",
            "recorded":"true",
            "voicemail":"true",
            "introSoundId":10004001,
            "whisperSoundId":10005002,
            "voicemailSoundId":10006003,
            "failedTransferSoundId":10007004,
            "transferNumbers":
            [
                "12135551122",
                "12135551189"
            ],
            "weeklySchedule":
            {
                "startTimeOfDay":
                {
                    "hour": 10,
                    "minute": 0,
                    "second": 0
                },
                "stopTimeOfDay": 
                {
                    "hour": 18,
                    "minute": 0,
                    "second": 0
                },
                "daysOfWeek": [
                    "MONDAY",
                    "TUESDAY",
                    "WEDNESDAY",
                    "THURSDAY",
                    "FRIDAY"
                ],
                "timeZone": "America/New_York"
            },
            "googleAnalytics": 
            {
                "domain":"domain-name",
                "googleAccountId":"UA-XXXXX-2X",
                "category":"Sales"
            }
        }
    }' "https://api.callfire.com/v2/numbers/leases/configs/19206596476"
