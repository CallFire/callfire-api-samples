<?php

class ApiClientSample {

    public static function main() {
        $client = \CallFire\Api\DocumentedClient::createClient("login", "password");
        $request = $client->removeContactListItem();
        $request->getOperationConfig()->setPathParameters(array("id" => 11646003,
                                                                "contactId" => 22277003));
        $result = $client->request($request);
        $json = json_decode($result->getBody());
    }
}

ApiClientSample::main();
