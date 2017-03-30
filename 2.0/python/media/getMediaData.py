from callfire.client import CallfireClient

client = CallfireClient('api-login', 'api-password')
response = client.media.getMediaData(
    id=379506003,
    extension='mp3'
).result()

# see sample JSON response for this API
# on 'curl' samples tab
print(response)