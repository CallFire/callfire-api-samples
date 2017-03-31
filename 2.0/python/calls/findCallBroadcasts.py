from callfire.client import CallfireClient

client = CallfireClient('api-login', 'api-password')
response = client.calls.findCallBroadcasts(
    # filter by name
    name='broadcast name',
    # filter by label
    label='my label',
    # filter only broadcasts in RUNNING state
    running=True,
    # search offset
    offset=0,
    # return 10 items per request
    limit=10,
    # return only specific fields
    fields='items(id,name,status,sounds)'
).result()

# see sample JSON response for this API
# on 'curl' samples tab
print(response)