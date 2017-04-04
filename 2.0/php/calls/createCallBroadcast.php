<?php

class ApiClientSample{

    public static function main(){
        $client = \CallFire\Api\DocumentedClient::createClient("login", "password");
        $request = $client->createCallBroadcast();
        $queryParameters = array('start' => false);
        $request->getOperationConfig()->setHeaderParameters(array("Content-Type" => "application/json"));
        $body = '{
                    "name":"Example API Call Broadcast",
                    "fromNumber":"12135551189",
                    "recipients":
                    [
                        {
                            "phoneNumber":"2135551133"
                        }
                    ],
                    "answeringMachineConfig":"AM_AND_LIVE",
                    "sounds":
                    {
                        "liveSoundText":"Hello! This is a live answer text to speech recording",
                        "machineSoundText":"This is an answering machine text to speech recording"
                    },
                    "resumeNextDay":"true"
                }';
        $request->getOperationConfig()->setQueryParameters($queryParameters);
        $request->getOperationConfig()->setBodyParameter($body);
        $result = $client->request($request);
        $json = json_decode($result->getBody());
    }
}

ApiClientSample::main();
