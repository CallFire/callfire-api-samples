from callfire.client import CallfireClient

client = CallfireClient('api-login', 'api-password')
response = client.calls.getCallRecordingMp3ByName(
    id=379506003,
    name='call-recording1'
).result()

# see sample JSON response for this API
# on 'curl' samples tab
print(response)