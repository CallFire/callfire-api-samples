from callfire.client import CallfireClient

client = CallfireClient('api-login', 'api-password')
response = client.me.sendVerificationCodeToCallerId(callerid='12132000384').result()

# see sample JSON response for this API
# on 'curl' samples tab
print(response)
