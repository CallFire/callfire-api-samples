from callfire.client import CallfireClient

client = CallfireClient('api-login', 'api-password')
response = client.webhooks.getWebhook(
    id=379506003,
    # return only specific fields
    fields='name,callback'
).result()

print(response)
