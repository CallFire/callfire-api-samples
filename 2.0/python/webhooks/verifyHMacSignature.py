import base64
import hashlib
import hmac


def getHmacSignature(data, secret):

    digest = hmac.new(
        key=str.encode(secret),
        msg=str.encode(data),
        digestmod=hashlib.sha1).digest()

    hmacSignature = base64.b64encode(digest)

    return hmacSignature


# then check signature in listener code
# data = "{\"name\":\"test webhook\", \"callback\":\"sms:callfire\"}"
# secret = 'mysecrets'
# result = hmac.compare_digest(b'v14pF7d5C1+CHNIEWlg+sw9v0Xg=', getHmacSignature(data, secret))
# assert result == True
