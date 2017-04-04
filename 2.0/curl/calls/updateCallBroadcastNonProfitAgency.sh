#!/usr/bin/env bash

curl -u username:password -H "Content-Type:application/json" -X PUT -d '
{
  "schedules": [
    {
      "startTimeOfDay": {
        "hour": 10,
        "minute": 0,
        "second": 0
      },
      "stopTimeOfDay": {
        "hour": 18,
        "minute": 0,
        "second": 0
      },
      "daysOfWeek": [
        "SATURDAY",
        "SUNDAY"
      ],
      "timeZone": "America/New_York",
      "startDate": {
        "year": 2016,
        "month": 12,
        "day": 1
      },
      "stopDate": {
        "year": 2016,
        "month": 12,
        "day": 10
      }
    },
    {
      "startTimeOfDay": {
        "hour": 10,
        "minute": 0,
        "second": 0
      },
      "stopTimeOfDay": {
        "hour": 18,
        "minute": 0,
        "second": 0
      },
      "daysOfWeek": [
        "SATURDAY",
        "SUNDAY"
      ],
      "timeZone": "America/New_York",
      "startDate": {
        "year": 2016,
        "month": 12,
        "day": 20
      },
      "stopDate": {
        "year": 2016,
        "month": 12,
        "day": 30
      }
    }
  ]
}' "https://api.callfire.com/v2/calls/broadcasts/10030003"
