from callfire.client import CallfireClient

client = CallfireClient('api-login', 'api-password')
response = client.texts.getTextBroadcastTexts(
    id=11646003,
    # get texts assigned to particular contact batch
    batchId=5500030002,
    # search offset
    offset=0,
    # return 10 items per request
    limit=10,
    # return only specific fields
    fields='items(fromNumber,toNumber,state,message)'
).result()

print(response)
