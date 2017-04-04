<?php

class ApiClientSample{

    public static function main(){
        $client = \CallFire\Api\DocumentedClient::createClient("login", "password");
        $request = $client->getCallRecording();
        $request->getOperationConfig()->setPathParameters(array("id" => 123454563));
        $request->getOperationConfig()->setQueryParameters(array("fields" => "campaignId"));
        $result = $client->request($request);
        $json = json_decode($result->getBody());
    }
}

ApiClientSample::main();
