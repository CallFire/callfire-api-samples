<?php

class ApiClientSample {

    public static function main() {
        $client = \CallFire\Api\DocumentedClient::createClient("login", "password");
        $request = $client->getWebhookResource();
        $request->getOperationConfig()->setPathParameters(array("resource" => "CALL_BROADCAST"));
        $request->getOperationConfig()->setQueryParameters(array("fields" => "resource,events"));
        $result = $client->request($request);
        $json = json_decode($result->getBody());
    }
}

ApiClientSample::main();
