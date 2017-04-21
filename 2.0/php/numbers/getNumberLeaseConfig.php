<?php

class ApiClientSample {

    public static function main() {
        $client = \CallFire\Api\DocumentedClient::createClient("login", "password");
        $request = $client->getNumberLeaseConfig();
        $request->getOperationConfig()->setPathParameters(array("number" => "12132000384"));
        $request->getOperationConfig()->setQueryParameters(array("fields" => "number,configType"));
        $result = $client->request($request);
        $json = json_decode($result->getBody());
    }
}

ApiClientSample::main();
