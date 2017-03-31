from callfire.client import CallfireClient

client = CallfireClient('api-login', 'api-password')
response = client.texts.findTexts(
    inbound=True,
    campaignId=1003002,
    limit=10
).result()

# see sample JSON response for this API
# on 'curl' samples tab
print(response)