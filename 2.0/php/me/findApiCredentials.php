<?php

class ApiClientSample {

    public static function main() {
        $client = \CallFire\Api\DocumentedClient::createClient("account_login", "account_password");
        $request = $client->findApiCredentials();
        $request->getOperationConfig()->setQueryParameters(array("fields" => "name,enabled"));
        $result = $client->request($request);
        $json = json_decode($result->getBody());
    }
}

ApiClientSample::main();
