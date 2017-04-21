<?php

class ApiClientSample {

    public static function main() {
        $client = \CallFire\Api\DocumentedClient::createClient("login", "password");
        $request = $client->removeContactListItems();
        $request->getOperationConfig()->setPathParameters(array("11646003" => 123456));
        $request->getOperationConfig()->setQueryParameters(array("contactId" => 22277003,
                                                                 "contactId" => 23377003));
        $result = $client->request($request);
        $json = json_decode($result->getBody());
    }
}

ApiClientSample::main();
