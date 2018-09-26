from callfire.client import CallfireClient
client = CallfireClient('api-login', 'api-password')

# get account info
response = client.media.findMedia(
    filter='image1.jpeg'
).result()

#see sample JSON response for this APIon 'curl' samples tab

print(response)