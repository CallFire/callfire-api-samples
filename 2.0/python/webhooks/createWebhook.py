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

# see sample JSON response for this API
# on 'curl' samples tab
print(response)