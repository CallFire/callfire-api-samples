<?php

class ApiClientSample {

    public static function main() {
        $client = \CallFire\Api\DocumentedClient::createClient("login", "password");
        $request = $client->getMediaData();
        $request->getOperationConfig()->setPathParameters(array("id" => 379506003,
                                                                "extension" => "mp3"));
        //Available media types:
        //JPEG("jpeg", "image/jpeg"),
        //PNG("png", "image/png"),
        //BMP("bmp", "image/bmp"),
        //GIF("gif", "image/gif"),
        //MP4("mp4", "video/mp4"),
        //M4A("m4a", "audio/m4a"),
        //MP3("mp3", "audio/mp3"),
        //WAV("wav", "audio/x-wav"),
        //UNKNOWN("unknown", "application/octet-stream");
        $result = $client->request($request);
    }
}

ApiClientSample::main();
