from callfire.client import CallfireClient

client = CallfireClient('api-login', 'api-password')
response = client.calls.getCallRecordings(
    id=379506003,
    # return only specific fields
    fields='items(callId,campaignId,lengthInBytes,mp3Url)'
).result()

# see sample JSON response for this API
# on 'curl' samples tab
print(response)