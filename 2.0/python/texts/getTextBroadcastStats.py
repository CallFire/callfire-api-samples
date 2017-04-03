from callfire.client import CallfireClient

client = CallfireClient('api-login', 'api-password')
response = client.texts.getTextBroadcastStats(
    id=11646003,
    # filter by time interval
    begin=1473781817000,
    # filter by time interval
    end=1473781817000,
    # return only specific fields
    fields='totalOutboundCount,billedAmount,sentCount'
).result()

# see sample JSON response for this API
# on 'curl' samples tab
print(response)
