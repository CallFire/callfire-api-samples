<?php

class ApiClientSample {

    public static function main() {
        $client = \CallFire\Api\DocumentedClient::createClient("login", "password");
        $request = $client->addCallBroadcastBatch();
        $request->getOperationConfig()->setPathParameters(array("id" => 11646003));
        $body = '{
                    "name":"Contact Batch 1",
                    "contactListId": 300555001,
                    "scrubDuplicates": true
                 }';
        $request->getOperationConfig()->setBodyParameter($body);
        $result = $client->request($request);
        $json = json_decode($result->getBody());
    }
}

ApiClientSample::main();
