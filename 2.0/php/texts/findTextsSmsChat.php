<?php

class ApiClientSample{

    public static function main(){
        $client = \CallFire\Api\DocumentedClient::createClient("login", "password");
        $request = $client->findTexts();
        $request->getOperationConfig()->setQueryParameters(array("fromNumber" => "12135551100",
                                                                 "fields" => "items(id,message,created)",
                                                                 "intervalBegin" => 1448920800000,
                                                                 "intervalEnd" => 1449698400000,
                                                                 "limit" => 50,
                                                                 "offset" => 100));
        $result = $client->request($request);
        $json = json_decode($result->getBody());
    }
}

ApiClientSample::main();
