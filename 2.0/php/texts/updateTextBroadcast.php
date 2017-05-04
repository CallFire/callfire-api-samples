<?php

class ApiClientSample {

    public static function main() {
        $client = \CallFire\Api\DocumentedClient::createClient("login", "password");
        $request = $client->updateTextBroadcast();
        $request->getOperationConfig()->setPathParameters(array("id" => 11646003));
        $body = '{
                    "name":"Campaign name updated",
                    "message":"a new test message"
                 }';
        $request->getOperationConfig()->setBodyParameter($body);
        $result = $client->request($request);
        $json = json_decode($result->getBody());
    }
}

ApiClientSample::main();
