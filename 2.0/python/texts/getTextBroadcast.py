from callfire.client import CallfireClient

client = CallfireClient('api-login', 'api-password')
response = client.texts.getTextBroadcast(
    id=379506003,
    # return only specific fields
    fields='name,status,labels'
).result()

print(response)
