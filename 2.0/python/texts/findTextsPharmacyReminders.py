from callfire.client import CallfireClient

client = CallfireClient('api-login', 'api-password')
response = client.texts.findTexts(
    campaignId=13,
    label='reminders',
    intervalBegin=1448920800000,
    intervalEnd=1449698400000,
    limit=10
).result()

print(response)
