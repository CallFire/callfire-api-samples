<?php

class ApiClientSample {

    public static function main() {
        $client = \CallFire\Api\DocumentedClient::createClient("login", "password");
        $request = $client->updateWebhook();
        $request->getOperationConfig()->setPathParameters(array("id" => 11646003));
        $body = '{
                    "name":"sms sent update",
                    "events":["Finished"],
                    "callback":"https://callback-service.com/listener2"
                 }';
        $request->getOperationConfig()->setBodyParameter($body);
        $result = $client->request($request);
        $json = json_decode($result->getBody());
    }
}

ApiClientSample::main();
