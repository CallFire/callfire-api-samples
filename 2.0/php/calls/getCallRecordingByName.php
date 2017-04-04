<?php

class ApiClientSample{

    public static function main(){
        $client = \CallFire\Api\DocumentedClient::createClient("login", "password");
        $request = $client->getCallRecordingByName();
        $request->getOperationConfig()->setPathParameters(array("id" => 123454563,
                                                                "name" => "testName"));
        $request->getOperationConfig()->setQueryParameters(array("fields" => "callId"));
        $result = $client->request($request);
        $json = json_decode($result->getBody());
    }
}

ApiClientSample::main();
