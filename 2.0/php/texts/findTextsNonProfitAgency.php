<?php

class ApiClientSample{

    public static function main(){
        $client = \CallFire\Api\DocumentedClient::createClient("login", "password");
        $request = $client->findTexts();
        $request->getOperationConfig()->setQueryParameters(array("campaignId" => 7415225003,
                                                                 "inbound" => true));
        $result = $client->request($request);
        $json = json_decode($result->getBody());
    }
}

ApiClientSample::main();
