from callfire.client import CallfireClient

client = CallfireClient('api-login', 'api-password')
response = client.webhooks.findWebhookResources(fields='items(events)').result()

print(response)
