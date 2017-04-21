<?php

function getHmacSignature($data, $secret) {
    return base64_encode(hash_hmac('sha1', $data, $secret, true));
}

// then check signature in listener code
// $data = "{\"name\":\"test webhook\", \"callback\":\"sms:callfire\"}";
// $secret = "mysecrets";
// assert("v14pF7d5C1+CHNIEWlg+sw9v0Xg=" == getHmacSignature($data, $secret));

