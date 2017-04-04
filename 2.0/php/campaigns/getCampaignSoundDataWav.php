<?php

class ApiClientSample{

    public static function main(){
        $client = \CallFire\Api\DocumentedClient::createClient("login", "password");
        $request = $client->getCampaignSoundDataWav();
        $request->getOperationConfig()->setPathParameters(array("id" => 12345));
        $result = $client->request($request);
    }
}

ApiClientSample::main();

