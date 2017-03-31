from callfire.client import CallfireClient

client = CallfireClient('api-login', 'api-password')
response = client.texts.findTextAutoReplys(
    # filter by number
    number=12132000384,
    # search offset
    offset=0,
    # return 10 items per request
    limit=10,
    # return only specific fields
    fields='items(id,match,keyword,message)'
).result()

# see sample JSON response for this API
# on 'curl' samples tab
print(response)