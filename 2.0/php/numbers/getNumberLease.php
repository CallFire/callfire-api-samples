<?php

class ApiClientSample {

    public static function main() {
        $client = \CallFire\Api\DocumentedClient::createClient("login", "password");
        $request = $client->getNumberLease();
        $request->getOperationConfig()->setPathParameters(array("number" => "12132000384"));
        $request->getOperationConfig()->setQueryParameters(array("fields" => "number,nationalFormat,leaseBegin,leaseEnd,region/city"));
        $result = $client->request($request);
        $json = json_decode($result->getBody());
    }
}

ApiClientSample::main();

