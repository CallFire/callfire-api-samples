<?php

class ApiClientSample{

    public static function main(){
        $client = \CallFire\Api\DocumentedClient::createClient("login", "password");
        $request = $client->findNumbersLocal();
        $request->getOperationConfig()->setQueryParameters(array("limit" => 2,
                                                                 "zipcode" => "90401"));
        $result = $client->request($request);
        $json = json_decode($result->getBody());
    }
}

ApiClientSample::main();
