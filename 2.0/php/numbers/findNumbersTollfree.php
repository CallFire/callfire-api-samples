<?php

class ApiClientSample{

    public static function main(){
        $client = \CallFire\Api\DocumentedClient::createClient("login", "password");
        $request = $client->findNumbersTollfree();
        $request->getOperationConfig()->setQueryParameters(array("limit" => 2,
                                                                 "offset" => 0));
        $result = $client->request($request);
        $json = json_decode($result->getBody());
    }
}

ApiClientSample::main();
