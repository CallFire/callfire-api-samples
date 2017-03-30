from callfire.client import CallfireClient

client = CallfireClient('api-login', 'api-password')
response = client.media.getMediaDataByKey(
    key='f733daab-fc05-470d-abe6-87cd136599ad',
    extension='mp3'
).result()

# see sample JSON response for this API
# on 'curl' samples tab
print(response)