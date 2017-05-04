<?php

class ApiClientSample {

    public static function main() {
        $client = \CallFire\Api\DocumentedClient::createClient("login", "password");
        $request = $client->sendTexts();
        $request->getOperationConfig()->setQueryParameters(array("campaignId" => 4050600003,
                                                                 "defaultMessage" => "Hello!"));
        $body = '[
                    {
                        "phoneNumber":"12135551122",
                        "message":"Hello World!"
                    },
                    {
                        "contactId":122460000043
                    },
                    {
                        "phoneNumber":"12135558090",
                        "attributes":
                        {
                            "custom_external_id": 30005044,
                            "custom_name": "Alice"
                        },
                        "message": "Hello, ${custom_name}!"
                    }
                 ]';
        $request->getOperationConfig()->setBodyParameter($body);
        $result = $client->request($request);
        $json = json_decode($result->getBody());
    }
}

ApiClientSample::main();
