from callfire.client import CallfireClient

client = CallfireClient('api-login', 'api-password')
response = client.texts.findTexts(
    # filter by fromNumber
    fromNumber='12135551100',
    # filter by time interval
    intervalBegin=1473781817000,
    # filter by time interval
    intervalEnd=1473781917000,
    # start from 100' item
    offset=100,
    # return 50 items per request
    limit=50,
    # return only specific fields
    fields='items(id,message,created)'
).result()

# see sample JSON response for this API
# on 'curl' samples tab
print(response)
