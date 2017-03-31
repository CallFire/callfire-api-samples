from callfire.client import CallfireClient

client = CallfireClient('api-login', 'api-password')
response = client.contacts.getContactList(
    id=379506003,
    # return only specific fields
    fields='id,name,size,created'
).result()

# see sample JSON response for this API
# on 'curl' samples tab
print(response)
