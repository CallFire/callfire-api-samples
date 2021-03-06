<?php

class ApiClientSample {

    public static function main() {
        $client =\CallFire\Api\DocumentedClient::createClient ("login", "password");
        $request = $client -> createWebhook();
        $body = '{
                    "name":"Sms sent",
                    "resource":"OutboundText",
                    "events":["Finished"],
                    "callback":"https://callback-service.com/listener"
                 }';
        $request->getOperationConfig()->setBodyParameter($body);
        $result = $client->request($request);
        $json = json_decode($result->getBody());
    }
}

ApiClientSample::main();
