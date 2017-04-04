<?php

class ApiClientSample{

    public static function main(){
        $client = \CallFire\Api\DocumentedClient::createClient("login", "password");
        $request = $client->findCampaignSounds();
        $request->getOperationConfig()->setQueryParameters(array("limit" => 1,
                                                                 "filter" => "sample"));
        $result = $client->request($request);
        $json = json_decode($result->getBody());
    }
}

ApiClientSample::main();
