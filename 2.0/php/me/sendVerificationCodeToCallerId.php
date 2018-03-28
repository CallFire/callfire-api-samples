<?php

class ApiClientSample {

    public static function main() {
        $client = \CallFire\Api\DocumentedClient::createClient("api_login", "api_password");
        $request = $client->sendVerificationCodeToCallerId();
        $request->getOperationConfig()->setPathParameters(array("callerid" => "12132000384"));
        $result = $client->request($request);
        $json = json_decode($result->getBody());
    }
}

ApiClientSample::main();
