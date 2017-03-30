from callfire.client import CallfireClient

client = CallfireClient('api-login', 'api-password')
response = client.me.sendVerificationCodeToCallerId(callerid='12132000384').result()

print(response)
