<?php

class ApiClientSample {

    public static function main() {
        $client = \CallFire\Api\DocumentedClient::createClient("login", "password");
        $request = $client->updateNumberLease();
        $request->getOperationConfig()->setPathParameters(array("number" => "19206596476"));
        $body = '{
                    "callFeatureStatus":"DISABLED",
                    "autoRenew":"false"
                 }';
        $request->getOperationConfig()->setBodyParameter($body);
        $result = $client->request($request);
        $json = json_decode($result->getBody());
    }
}

ApiClientSample::main();
