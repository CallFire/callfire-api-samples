<?php

class ApiClientSample {

    public static function main() {
        $client = \CallFire\Api\DocumentedClient::createClient("login", "password");
        $request = $client->createCallBroadcast();
        $body = '{
                    "name": "Charity Campaign",
                    "fromNumber": "12135551189",
                    "answeringMachineConfig": "AM_AND_LIVE",
                    "labels":
                    [
                        "charity",
                        "id-10002"
                    ],
                    "sounds":
                    {
                        "liveSoundText": "Hello, this is Mary, from the local branch of Non-profit agency. Do not miss our charity weekend taking place at first November weekends. We are looking forward to meet you there. Press 1 to to find out more details.",
                        "liveSoundTextVoice": "MALE1",
                        "machineSoundText": "Hello, this is Mary, from the local branch of Non-profit agency. If you are interested in charity weekend, please call (231) 455-7676.",
                        "machineSoundTextVoice": "MALE1",
                        "transferSoundText": "Please wait a moment, call is being transfer.",
                        "transferDigit": "1",
                        "transferNumber": "12314557676",
                    },
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
                    },
                    "recipients":
                    [
                        {
                            "phoneNumber": "12135551100",
                            "attributes":
                            {
                                "age": "30",
                                "position": "Manager"
                            }
                        },
                        {
                            "phoneNumber": "12135771188",
                            "attributes":
                            {
                                "external_system_id": "34347770001",
                                "call_label": "friends"
                            }
                        },
                        {
                            "contactId": 46000044001
                        }
                    ]
                 }';
        $request->getOperationConfig()->setBodyParameter($body);
        $result = $client->request($request);
        $json = json_decode($result->getBody());
    }
}

ApiClientSample::main();



