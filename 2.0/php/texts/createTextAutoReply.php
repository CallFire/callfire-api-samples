<?php

class ApiClientSample {

    public static function main() {
        $client = \CallFire\Api\DocumentedClient::createClient("login", "password");
        $request = $client->createTextAutoReply();
        $request->getOperationConfig()->setHeaderParameters(array("Content-Type" => "application/json"));
        $body = '{
                    "number":"67076",
                    "keyword":"CALLFIRE",
                    "message":"I am a leaf on the wind"
                 }';
        $request->getOperationConfig()->setBodyParameter($body);
        $result = $client->request($request);
        $json = json_decode($result->getBody());
    }
}

ApiClientSample::main();
