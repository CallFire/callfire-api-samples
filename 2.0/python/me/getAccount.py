from callfire.client import CallfireClient

client = CallfireClient('api-login', 'api-password')
response = client.me.getAccount().result()

# see sample JSON response for this API
# on 'curl' samples tab
print(response)