<?php

class ApiClientSample{

    public static function main(){
        $client = \CallFire\Api\DocumentedClient::createClient("login", "password");
        $request = $client->getTextBroadcastBatches();
        $request->getOperationConfig()->setPathParameters(array("id" => 1234));
        $request->getOperationConfig()->setQueryParameters(array("limit" => 10));
        $result = $client->request($request);
        $json = json_decode($result->getBody());
    }
}

ApiClientSample::main();

