from callfire.client import CallfireClient

client = CallfireClient('account-login', 'account-password')
response = client.me.createApiCredential(
    body={
        'name': 'api-integration'
    }
).result()

# see sample JSON response for this API
# on 'curl' samples tab
print(response)
