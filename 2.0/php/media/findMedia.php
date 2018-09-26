<?php

class ApiClientSample {
    public static function main() {
        $client = \CallFire\Api\DocumentedClient::createClient("login", "password");
        $request = $client->findMedia();
        $request->getOperationConfig()->setQueryParameters(array(
            "filter" => "image1.jpeg"
        ));
        $result = $client->request($request);
        $json = json_decode($result->getBody());
    }
}