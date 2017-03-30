from callfire.client import CallfireClient

client = CallfireClient('account-login', 'account-password')
response = client.me.createApiCredential(
    body={
        'name': 'api-integration'
    }
).result()

print(response)
