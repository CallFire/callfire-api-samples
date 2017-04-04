<?php

class ApiClientSample{

    public static function main(){
        $client = \CallFire\Api\DocumentedClient::createClient("login", "password");
        $request = $client->getCampaignSound();
        $request->getOperationConfig()->setPathParameters(array("id" => 12345));
        $request->getOperationConfig()->setQueryParameters(array("fields" => "name,status,lengthInSeconds"));
        $result = $client->request($request);
        $json = json_decode($result->getBody());
    }
}

ApiClientSample::main();

