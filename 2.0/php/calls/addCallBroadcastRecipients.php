<?php

class ApiClientSample {

    public static function main() {
        $client = \CallFire\Api\DocumentedClient::createClient("login", "password");
        $request = $client->addCallBroadcastRecipients();
        $request->getOperationConfig()->setPathParameters(array("id" => 11646003));
        $body = '[
                    {
                        "phoneNumber":"12135551122"
                    },
                    {
                        "contactId":122460000043
                    },
                    {
                        "phoneNumber":"12135558090",
                        "attributes":
                        {
                            "custom_external_id": 30005044,
                            "custom_property_1": "value1"
                        }
                    }
                 ]';
        $request->getOperationConfig()->setBodyParameter($body);
        $result = $client->request($request);
        $json = json_decode($result->getBody());
    }
}

ApiClientSample::main();
