<?php

class ApiClientSample {

    public static function main() {
        $client = \CallFire\Api\DocumentedClient::createClient("login", "password");
        $request = $client->getCallRecordingMp3ByName();
        $request->getOperationConfig()->setPathParameters(array("id" => 379506003,
                                                                "name" => "call-recording1"));
        $result = $client->request($request);
    }
}

ApiClientSample::main();

