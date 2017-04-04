<?php

class ApiClientSample{

    public static function main(){
        $client = \CallFire\Api\DocumentedClient::createClient("login", "password");
        // find all calls made through campaign with id = 10, label = reminders is assigned to such campaign,
        // between 2015-12-01 and 2015-12-10, return first 10 records if any
        $request = $client->findCalls();
        $request->getOperationConfig()->setQueryParameters(array("campaignId" => 10,
                                                                 "label" => "reminders",
                                                                 "intervalBegin" => 1448920800000,
                                                                 "intervalEnd" => 1449698400000,
                                                                 "limit" => 10));
        $result = $client->request($request);
        $json = json_decode($result->getBody());
    }
}

ApiClientSample::main();
