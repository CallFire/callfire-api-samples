<?php

class ApiClientSample {

    public static function main() {
        $client = \CallFire\Api\DocumentedClient::createClient("login", "password");
        $request = $client->getKeywordLease();
        $request->getOperationConfig()->setPathParameters(array("keyword" => "SUN"));
        $request->getOperationConfig()->setQueryParameters(array("fields" => "items(keyword,leaseBegin,leaseEnd)"));
        $result = $client->request($request);
        $json = json_decode($result->getBody());
    }
}

ApiClientSample::main();

