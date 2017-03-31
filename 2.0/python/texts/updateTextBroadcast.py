from callfire.client import CallfireClient

client = CallfireClient('api-login', 'api-password')
client.texts.updateTextBroadcast(
    id=11646003,
    body={
        'name': 'Campaign name updated',
        'message': 'a new test message'
    }
).result()
