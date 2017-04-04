<?php

class ApiClientSample{

    public static function main(){
        $client = \CallFire\Api\DocumentedClient::createClient("login", "password");
        $request = $client->getCallRecordingMp3ByName();
        $request->getOperationConfig()->setPathParameters(array("id" => 123454563,
                                                                "name" => "testName"));
        $result = $client->request($request);
    }
}

ApiClientSample::main();
