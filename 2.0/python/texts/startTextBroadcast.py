from callfire.client import CallfireClient

client = CallfireClient('api-login', 'api-password')
client.texts.startTextBroadcast(id=11646003).result()
