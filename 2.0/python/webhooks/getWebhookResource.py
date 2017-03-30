from callfire.client import CallfireClient

client = CallfireClient('api-login', 'api-password')
response = client.webhooks.getWebhookResource(
    resource='CallBroadcast',
    # return only specific fields
    fields='resource,events'
).result()

# see sample JSON response for this API
# on 'curl' samples tab
print(response)