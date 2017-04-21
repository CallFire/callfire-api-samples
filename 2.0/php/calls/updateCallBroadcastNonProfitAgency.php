<?php

class ApiClientSample {

    public static function main() {
        $client = \CallFire\Api\DocumentedClient::createClient("login", "password");
        $request = $client->updateCallBroadcast();
        $request->getOperationConfig()->setHeaderParameters(array("Content-Type" => "application/json"));
        $request->getOperationConfig()->setPathParameters(array("id" => 11646003));
        $body = '{
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
                        },
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
                                "day": 20
                            },
                            "stopDate":
                            {
                                "year": 2016,
                                "month": 12,
                                "day": 30
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
