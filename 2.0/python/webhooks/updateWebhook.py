from callfire.client import CallfireClient

client = CallfireClient('api-login', 'api-password')
client.webhooks.updateWebhook(
    id=11646003,
    body={
        'name': 'sms sent update',
        'events': ['Finished'],
        'callback': 'https://callback-service.com/listener2'
    }
)
