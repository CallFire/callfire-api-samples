<?php

class ApiClientSample{

    public static function main(){
        $client = \CallFire\Api\DocumentedClient::createClient("account_login", "account_password");
        $request = $client->getCreditUsage();
        $request->getOperationConfig()->setQueryParameters(array("intervalBegin" => 1448920800000,
                                                                 "intervalEnd" => 1449698400000));
        $result = $client->request($request);
        $json = json_decode($result->getBody());
    }
}

ApiClientSample::main();
