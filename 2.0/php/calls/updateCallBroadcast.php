<?php

class ApiClientSample {

    public static function main() {
        $client = \CallFire\Api\DocumentedClient::createClient("login", "password");
        $request = $client->updateCallBroadcast();
        $request->getOperationConfig()->setPathParameters(array("id" => 11646003));
        $body = '{
                    "name":"Call Broadcast with Schedules",
                    "answeringMachineConfig":"LIVE_IMMEDIATE",
                    "sounds":
                    {
                        "liveSoundText":"Hello! This is an updated Call Broadcast config tts"
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
                        }
                    ]
                }';
        $request->getOperationConfig()->setBodyParameter($body);
        $result = $client->request($request);
        $json = json_decode($result->getBody());
    }
}

ApiClientSample::main();
