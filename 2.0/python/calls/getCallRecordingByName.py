from callfire.client import CallfireClient

client = CallfireClient('api-login', 'api-password')
response = client.calls.getCallRecordingByName(
    id=379506003,
    name='call-recording1',
    # return only specific fields
    fields='callId,campaignId,lengthInBytes,mp3Url'
).result()

# see sample JSON response for this API
# on 'curl' samples tab
print(response)