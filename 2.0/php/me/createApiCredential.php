<?php

class ApiClientSample{

    public static function main() {
        $client =\CallFire\Api\DocumentedClient::createClient ("account_login", "account_password");
        $request = $client -> createApiCredential();
        $request -> getOperationConfig()->setHeaderParameters(array("Content-Type" => "application/json"));
        $body = '{
                    "name":"api_20_account"
                }';
        $request->getOperationConfig()->setBodyParameter($body);
        $result = $client->request($request);
        $json = json_decode($result->getBody());
    }
}

ApiClientSample::main();
