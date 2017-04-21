<?php

class ApiClientSample {

    public static function main() {
        $client = \CallFire\Api\DocumentedClient::createClient("login", "password");
        $request = $client->sendTexts();
        $request->getOperationConfig()->setHeaderParameters(array("Content-Type" => "application/json"));
        $body = '[
                    {
                        "phoneNumber":"12135551100",
                        "message":"Hey there",
                        "attributes":
                        {
                            "external_user_id":"45450007002"
                        }
                    }
                 ]';
        $request->getOperationConfig()->setBodyParameter($body);
        $result = $client->request($request);
        $json = json_decode($result->getBody());
    }
}

ApiClientSample::main();
