from callfire.client import CallfireClient

client = CallfireClient('api-login', 'api-password')
response = client.webhooks.createWebhook(
    body={
        'name': 'Call finished webhook',
        'resource': 'OutboundCall',
        'events': ['Finished'],
        'callback': 'http://callback-service.com/webhook'
    }
).result()

print(response)
