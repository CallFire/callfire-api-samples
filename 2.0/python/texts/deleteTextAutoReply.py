from callfire.client import CallfireClient

client = CallfireClient('api-login', 'api-password')
client.texts.deleteTextAutoReply(id=11646003).result()
