<?php

class ApiClientSample {

    public static function main() {
        $client = \CallFire\Api\DocumentedClient::createClient("login", "password");
        $request = $client->sendCalls();
        $request->getOperationConfig()->setHeaderParameters(array("Content-Type" => "application/json"));
        $body = '[
                    {
                        "phoneNumber":"12135551100",
                        "liveMessage":"Hello, Alice, this is message for live answer",
                        "machineMessage":"Hello, Alice, this is message for answering machine"
                    },
                    {
                        "phoneNumber":"12135551101",
                        "liveMessage":"Hello, Bob, this is message for live answer",
                        "machineMessage":"Hello, Bob, this is message for answering machine"
                    }
                 ]';
        $request->getOperationConfig()->setBodyParameter($body);
        $result = $client->request($request);
        $json = json_decode($result->getBody());
    }
}

ApiClientSample::main();
