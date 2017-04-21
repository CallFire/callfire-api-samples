<?php

class ApiClientSample {

    public static function main() {
        $client = \CallFire\Api\DocumentedClient::createClient("login", "password");
        $request = $client->getCallRecordingByName();
        $request->getOperationConfig()->setPathParameters(array("id" => 379506003,
                                                                "name" => "call-recording1"));
        $request->getOperationConfig()->setQueryParameters(array("fields" => "callId,campaignId,lengthInBytes,mp3Url"));
        $result = $client->request($request);
        $json = json_decode($result->getBody());
    }
}

ApiClientSample::main();
