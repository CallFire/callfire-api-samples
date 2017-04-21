<?php

class ApiClientSample {

    public static function main() {
        $client = \CallFire\Api\DocumentedClient::createClient("login", "password");
        $request = $client->findKeywordLeases();
        $request->getOperationConfig()->setQueryParameters(array("offset" => 0,
                                                                 "limit" => 10,
                                                                 "fields" => "items(keyword,leaseBegin,leaseEnd)"));
        $result = $client->request($request);
        $json = json_decode($result->getBody());
    }
}

ApiClientSample::main();

