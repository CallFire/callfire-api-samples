<?php

class ApiClientSample {

    public static function main() {
        $client = \CallFire\Api\DocumentedClient::createClient("login", "password");
        $request = $client->addTextBroadcastBatch();
        $request->getOperationConfig()->setPathParameters(array("id" => 11646003));
        $body = '{
                    "name":"contact batch for text",
                    "recipients":
                    [
                        {
                            "phoneNumber":"12135551122"
                        },
                        {
                            "phoneNumber":"12135553434"
                        },
                        {
                            "phoneNumber":"12135558090",
                            "attributes":
                            {
                                "custom_external_id": 30005044,
                                "custom_property_1": "value1"
                            }
                        }
                    ],
                    # or you can add contacts from particular contact list
                    # contactListId: 70055003
                    "scrubDuplicates":"true"
                 }';
        $request->getOperationConfig()->setBodyParameter($body);
        $result = $client->request($request);
        $json = json_decode($result->getBody());
    }
}

ApiClientSample::main();
