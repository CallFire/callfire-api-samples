<?php

class ApiClientSample {

    public static function main() {
        $client = \CallFire\Api\DocumentedClient::createClient("login", "password");
        $request = $client->postFileCampaignSound();
        $request->getOperationConfig()->setFileUpload(__dir__.'\sound1.mp3', 'campaign sound');
        $result = $client->request($request);
        $json = json_decode($result->getBody());
    }
}

ApiClientSample::main();
