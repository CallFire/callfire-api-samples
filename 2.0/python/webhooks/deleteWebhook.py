from callfire.client import CallfireClient

client = CallfireClient('api-login', 'api-password')
client.webhooks.deleteWebhook(id=11646003)
