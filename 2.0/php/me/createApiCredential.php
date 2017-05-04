<?php

class ApiClientSample{

    public static function main() {
        $client =\CallFire\Api\DocumentedClient::createClient ("account_login", "account_password");
        $request = $client -> createApiCredential();
        $body = '{
                    "name":"api-integration"
                 }';
        $request->getOperationConfig()->setBodyParameter($body);
        $result = $client->request($request);
        $json = json_decode($result->getBody());
    }
}

ApiClientSample::main();
