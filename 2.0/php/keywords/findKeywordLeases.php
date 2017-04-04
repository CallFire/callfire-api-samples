<?php

class ApiClientSample{

    public static function main(){
        $client = \CallFire\Api\DocumentedClient::createClient("login", "password");
        $request = $client->findKeywordLeases();
        $request->getOperationConfig()->setQueryParameters(array("limit" => 1,
                                                                 "offset" => 5));
        $result = $client->request($request);
        $json = json_decode($result->getBody());
    }
}

ApiClientSample::main();
