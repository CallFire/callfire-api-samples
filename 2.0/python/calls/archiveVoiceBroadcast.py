from callfire.client import CallfireClient

client = CallfireClient('api-login', 'api-password')
client.calls.archiveVoiceBroadcast(id=11646003).result()
