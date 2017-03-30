from callfire.client import CallfireClient

client = CallfireClient('api-login', 'api-password')
response = client.media.getMediaDataBinary(id=379506003).result()

print(response)
