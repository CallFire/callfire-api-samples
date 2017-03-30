from callfire.client import CallfireClient

client = CallfireClient('api-login', 'api-password')
response = client.media.getMedia(
    id=379506003,
    # return only specific fields
    fields='name,publicUrl'
).result()

print(response)
