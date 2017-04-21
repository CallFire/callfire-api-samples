<?php

class ApiClientSample {

    public static function main() {
        $client = \CallFire\Api\DocumentedClient::createClient("login", "password");
        $request = $client->getTextBroadcastTexts();
        $request->getOperationConfig()->setPathParameters(array("id" => 5500030002));
        $request->getOperationConfig()->setQueryParameters(array("offset" => 0,
                                                                 "limit" => 10,
                                                                 "fields" => "items(fromNumber,toNumber,state,message)"));
        $result = $client->request($request);
        $json = json_decode($result->getBody());
    }
}

ApiClientSample::main();
