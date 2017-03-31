from callfire.client import CallfireClient

client = CallfireClient('api-login', 'api-password')
response = client.contacts.getContactListItems(
    id=379506003,
    # search offset
    offset=0,
    # return 10 items per request
    limit=10,
    # return only specific fields
    fields='items(firstName,lastName,workPhone)'
).result()

# see sample JSON response for this API
# on 'curl' samples tab
print(response)
