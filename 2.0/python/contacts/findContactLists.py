from callfire.client import CallfireClient

client = CallfireClient('api-login', 'api-password')
response = client.contacts.findContactLists(
    # filter by partial contact list name
    name='my list',
    # search offset
    offset=0,
    # return 10 items per request
    limit=10,
    # return only specific fields
    fields='items(id,name,size)'
).result()

# see sample JSON response for this API
# on 'curl' samples tab
print(response)
