<?php

class ApiClientSample{

    public static function main(){
        $client = \CallFire\Api\DocumentedClient::createClient("login", "password");
        $request = $client->findTexts();
        $request->getOperationConfig()->setQueryParameters(array("id" => 600537356003,
                                                                 "campaignId" => 7415225003,
                                                                 "fromNumber" => "16502572135",
                                                                 "toNumber" => "16505044730"));
        $result = $client->request($request);
        $json = json_decode($result->getBody());
    }
}

ApiClientSample::main();
