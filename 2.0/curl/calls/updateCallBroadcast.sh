#!/usr/bin/env bash

curl -u username:password -H "Content-Type:application/json" -X PUT -d '
    {
        "name":"Call Broadcast with Schedules",
        "answeringMachineConfig":"LIVE_IMMEDIATE",
        "sounds":
        {
            "liveSoundText":"Hello! This is an updated Call Broadcast config tts"
        },
        "schedules": [
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
            "daysOfWeek":
            [
                "SATURDAY",
                "SUNDAY"
            ],
            "timeZone": "America/New_York",
            "startDate":
            {
                "year": 2016,
                "month": 12,
                "day": 1
            },
            "stopDate":
            {
                "year": 2016,
                "month": 12,
                "day": 10
            }
        }]
    }' "https://api.callfire.com/v2/calls/broadcasts/11646003"
