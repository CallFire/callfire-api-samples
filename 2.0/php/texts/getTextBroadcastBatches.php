<?php

class ApiClientSample {

    public static function main() {
        $client = \CallFire\Api\DocumentedClient::createClient("login", "password");
        $request = $client->getTextBroadcastBatches();
        $request->getOperationConfig()->setPathParameters(array("id" => 11646003));
        $request->getOperationConfig()->setQueryParameters(array("offset" => 0,
                                                                 "limit" => 10,
                                                                 "fields" => "items(name,status,size,remaining)"));
        $result = $client->request($request);
        $json = json_decode($result->getBody());
    }
}

ApiClientSample::main();
