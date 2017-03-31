from callfire.client import CallfireClient

client = CallfireClient('api-login', 'api-password')
response = client.calls.getCallBroadcastBatches(
    id=11646003,
    # search offset
    offset=0,
    # return 10 items per request
    limit=10,
    # return only specific fields
    fields='items(name,status,size,remaining)'
).result()

# see sample JSON response for this API
# on 'curl' samples tab
print(response)