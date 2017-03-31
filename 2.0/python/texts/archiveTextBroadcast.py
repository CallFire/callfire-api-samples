from callfire.client import CallfireClient

client = CallfireClient('api-login', 'api-password')
client.texts.archiveTextBroadcast(id=11646003).result()
