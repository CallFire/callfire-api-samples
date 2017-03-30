from callfire.client import CallfireClient

client = CallfireClient('api-login', 'api-password')
response = client.me.verifyCallerId(
    callerid='12132000384',
    body={
        'verificationCode': 1234
    }
).result()

print(response)
