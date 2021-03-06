<?php

class ApiClientSample {

    public static function main() {
        $client = \CallFire\Api\DocumentedClient::createClient("login", "password");
        $request = $client->getOrder();
        $request->getOperationConfig()->setPathParameters(array("id" => 379506003));
        $request->getOperationConfig()->setQueryParameters(array("fields" => "status,totalCost"));
        $result = $client->request($request);
        $json = json_decode($result->getBody());
    }
}

ApiClientSample::main();
