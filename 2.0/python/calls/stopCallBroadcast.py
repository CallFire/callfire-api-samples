from callfire.client import CallfireClient

client = CallfireClient('api-login', 'api-password')
client.calls.stopVoiceBroadcast(id=11646003).result()
