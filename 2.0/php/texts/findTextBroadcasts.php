<?php

class ApiClientSample{

    public static function main(){
        $client = \CallFire\Api\DocumentedClient::createClient("login", "password");
        $request = $client->findTextBroadcasts();
        $request->getOperationConfig()->setQueryParameters(array("name" => "campaign",
                                                                 "limit" => 2));
        $result = $client->request($request);
        $json = json_decode($result->getBody());
    }
}

ApiClientSample::main();
