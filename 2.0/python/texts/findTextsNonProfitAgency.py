from callfire.client import CallfireClient

client = CallfireClient('api-login', 'api-password')
response = client.texts.findTexts(
    inbound=True,
    campaignId=1003002,
    limit=10
).result()

print(response)
