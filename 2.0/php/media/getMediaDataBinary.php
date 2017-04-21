<?php

class ApiClientSample {

    public static function main() {
        $client = \CallFire\Api\DocumentedClient::createClient("login", "password");
        $request = $client->getMediaDataBinary();
        $request->getOperationConfig()->setPathParameters(array("id" => 379506003));
        $result = $client->request($request);
    }
}
