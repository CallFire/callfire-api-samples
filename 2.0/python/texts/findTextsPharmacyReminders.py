from callfire.client import CallfireClient

client = CallfireClient('api-login', 'api-password')
response = client.texts.findTexts(
    campaignId=13,
    label='reminders',
    intervalBegin=1448920800000,
    intervalEnd=1449698400000,
    limit=10
).result()

# see sample JSON response for this API
# on 'curl' samples tab
print(response)