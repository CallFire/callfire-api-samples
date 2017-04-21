<?php

class ApiClientSample {

    public static function main() {
        $client = \CallFire\Api\DocumentedClient::createClient("login", "password");
        $request = $client->createContactListFromFile();
        $request->getOperationConfig()->setFileUpload(__dir__.'\contacts.csv', 'My Contact List');
        $result = $client->request($request);
        $json = json_decode($result->getBody());
    }
}

ApiClientSample::main();
