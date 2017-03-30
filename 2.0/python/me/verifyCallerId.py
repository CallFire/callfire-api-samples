from callfire.client import CallfireClient

client = CallfireClient('api-login', 'api-password')
response = client.me.verifyCallerId(
    callerid='12132000384',
    body={
        'verificationCode': 1234
    }
).result()

# see sample JSON response for this API
# on 'curl' samples tab
print(response)
