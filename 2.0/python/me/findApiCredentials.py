from callfire.client import CallfireClient

client = CallfireClient('account-login', 'account-password')
response = client.me.findApiCredentials(
    # return only specific fields
    fields='name,enabled'
).result()

print(response)
