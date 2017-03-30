from callfire.client import CallfireClient

client = CallfireClient('account-login', 'account-password')
response = client.me.getApiCredential(
    id=379506003,
    # return only specific fields
    fields='name,enabled'
).result()

print(response)
