from callfire.client import CallfireClient

client = CallfireClient('api-login', 'api-password')
response = client.texts.createTextAutoReply(
    body={
        'number': '67076',
        'keyword': 'CALLFIRE',
        'message': 'I am a leaf on the wind'
    }
).result()

print(response)
