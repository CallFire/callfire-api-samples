from callfire.client import CallfireClient

client = CallfireClient('api-login', 'api-password')
response = client.media.createMedia(
    name='test image',
    file=open('image1.bmp', 'rb')
).result()

print(response)
