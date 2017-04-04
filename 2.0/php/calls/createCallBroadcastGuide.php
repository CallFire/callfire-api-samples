<?php

class ApiClientSample{

    public static function main(){
        $client = \CallFire\Api\DocumentedClient::createClient("login", "password");
        $request = $client->createCallBroadcast();
        $request->getOperationConfig()->setHeaderParameters(array("Content-Type" => "application/json"));
        $body = '{
                    "name":"Call Broadcast",
                    "fromNumber":"12135551189",
                    "answeringMachineConfig":"AM_AND_LIVE",
                    "sounds":
                    {
                        "liveSoundText":"Hello! This is a live answer text to speech recording",
                        "machineSoundText":"This is an answering machine text to speech recording"
                    },
                    "labels":
                    [
                        "voice tag",
                        "id-10002"
                    ],
                    "localTimeRestriction":
                    {
                        "beginHour": 9,
                        "beginMinute": 0,
                        "endHour": 18,
                        "endMinute": 0
                    },
                    "schedules":
                    [
                        {
                            "startTimeOfDay":
                            {
                                "hour": 10,
                                "minute": 0,
                                "second": 0
                            },
                            "daysOfWeek":
                            [
                                "MONDAY",
                                "WEDNESDAY"
                            ],
                            "timeZone": "America/New_York",
                            "startDate":
                            {
                                "year": 2016,
                                "month": 12,
                                "day": 1
                            }
                        }
                    ],
                    "retryConfig":
                    {
                        "maxAttempts": 2,
                        "minutesBetweenAttempts": 5,
                        "retryResults":
                        [
                            "BUSY",
                            "NO_ANS"
                        ],
                        "retryPhoneTypes":
                        [
                            "MOBILE_PHONE",
                            "WORK_PHONE"
                        ]
                    }
                }';
        $request->getOperationConfig()->setBodyParameter($body);
        $result = $client->request($request);
        $json = json_decode($result->getBody());
    }
}

ApiClientSample::main();



