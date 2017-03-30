from callfire.client import CallfireClient

client = CallfireClient('api-login', 'api-password')
response = client.webhooks.findWebhooks(
    # filter by webhook name
    name='my webhook',
    # filter by resource
    resource='TextBroadcast',
    # filter by event
    event='Started',
    # filter by callback URI
    callback='https://myservice/callback',
    # filter by enabled flag
    enabled=True,
    # search offset
    offset=0,
    # return 10 items per request
    limit=10,
    # return only specific fields
    fields='items(id,name,callback)'
).result()

print(response)
