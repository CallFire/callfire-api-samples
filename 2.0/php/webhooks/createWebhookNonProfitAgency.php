<?php

class ApiClientSample {

    public static function main() {
        $client =\CallFire\Api\DocumentedClient::createClient ("login", "password");
        $request = $client -> createWebhook();
        $body = '{
                    "name":"Call finished webhook",
                    "resource":"OutboundCall",
                    "events":["Finished"],
                    "callback":"http://callback-service.com/webhook"
                 }';
        $request->getOperationConfig()->setBodyParameter($body);
        $result = $client->request($request);
        $json = json_decode($result->getBody());
    }
}

ApiClientSample::main();
