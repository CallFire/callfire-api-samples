<?php

class ApiClientSample {

    public static function main() {
        $client = \CallFire\Api\DocumentedClient::createClient("api_login", "api_password");
        $request = $client->verifyCallerId();
        $request->getOperationConfig()->setPathParameters(array("callerid" => "12132000384"));
        $body = '{
                    "verificationCode":"1234"
                 }';
        $request->getOperationConfig()->setBodyParameter($body);
        $result = $client->request($request);
        $json = json_decode($result->getBody());
    }
}

ApiClientSample::main();
