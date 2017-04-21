<?php

class ApiClientSample {

    public static function main() {
        $client = \CallFire\Api\DocumentedClient::createClient("login", "password");
        $request = $client->updateNumberLeaseConfig();
        $request->getOperationConfig()->setHeaderParameters(array("Content-Type" => "application/json"));
        $request->getOperationConfig()->setPathParameters(array("number" => "19206596476"));
        $body = '{
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
                            "daysOfWeek":
                            [
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
                 }';
        $request->getOperationConfig()->setBodyParameter($body);
        $result = $client->request($request);
        $json = json_decode($result->getBody());
    }
}

ApiClientSample::main();
