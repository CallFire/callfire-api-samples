from callfire.client import CallfireClient

client = CallfireClient('api-login', 'api-password')
response = client.contacts.getDoNotContact(number='12135551126').result()

# see sample JSON response for this API
# on 'curl' samples tab
print(response)
