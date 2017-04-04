<?php

class ApiClientSample{

    public static function main(){
        $client = \CallFire\Api\DocumentedClient::createClient("login", "password");
        $request = $client->findTexts();
        $request->getOperationConfig()->setQueryParameters(array("campaignId" => 13,
                                                                 "label" => "reminders",
                                                                 "intervalBegin" => 1448920800000,
                                                                 "intervalEnd" => 1449698400000,
                                                                 "limit" => 10));
        $result = $client->request($request);
        $json = json_decode($result->getBody());
    }
}

ApiClientSample::main();
