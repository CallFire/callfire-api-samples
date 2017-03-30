from callfire.client import CallfireClient

client = CallfireClient('account-login', 'account-password')
response = client.me.findApiCredentials(
    # return only specific fields
    fields='name,enabled'
).result()

# see sample JSON response for this API
# on 'curl' samples tab
print(response)
