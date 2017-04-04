<?php

class ApiClientSample{

    public static function main(){
        $client = \CallFire\Api\DocumentedClient::createClient("login", "password");
        $request = $client->findNumberRegions();
        $request->getOperationConfig()->setQueryParameters(array("limit" => 2,
                                                                 "state" => "IL",
                                                                 "zipcode" => "60640"));
        $result = $client->request($request);
        $json = json_decode($result->getBody());
    }
}

ApiClientSample::main();
