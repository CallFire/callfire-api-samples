<?php

class ApiClientSample{

    public static function main(){
        $client = \CallFire\Api\DocumentedClient::createClient("login", "password");
        $request = $client->findWebhooks();
        $request->getOperationConfig()->setQueryParameters(array("name" => "test_name",
                                                                 "limit" => 5,
                                                                 "enabled" => true));
        $result = $client->request($request);
        $json = json_decode($result->getBody());
    }
}

ApiClientSample::main();
