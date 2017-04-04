<?php

class ApiClientSample{

    public static function main(){
        $client = \CallFire\Api\DocumentedClient::createClient("login", "password");
        $request = $client->addTextBroadcastBatch();
        $request->getOperationConfig()->setHeaderParameters(array("Content-Type" => "application/json"));
        $request->getOperationConfig()->setPathParameters(array("id" => 13));
        $body = '{
                    "name":"contact batch for text",
                    "recipients":
                    [
                        {
                            "phoneNumber":"12135551122"
                        }
                    ],
                    "scrubDuplicates":"true"
                }';
        $request->getOperationConfig()->setBodyParameter($body);
        $result = $client->request($request);
        $json = json_decode($result->getBody());
    }
}

ApiClientSample::main();
