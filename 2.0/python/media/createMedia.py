from callfire.client import CallfireClient

client = CallfireClient('api-login', 'api-password')
response = client.media.createMedia(
    name='test image',
    file=open('image1.bmp', 'rb')
).result()

# see sample JSON response for this API
# on 'curl' samples tab
print(response)