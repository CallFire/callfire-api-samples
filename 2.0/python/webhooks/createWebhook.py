from callfire.client import CallfireClient

client = CallfireClient('api-login', 'api-password')
response = client.webhooks.createWebhook(
    body={
        'name': 'sms sent',
        'resource': 'OutboundText',
        'events': ['Finished'],
        'callback': 'https://callback-service.com/listener'
    }
).result()

print(response)
