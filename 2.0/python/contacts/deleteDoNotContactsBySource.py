from callfire.client import CallfireClient

client = CallfireClient('api-login', 'api-password')
client.contacts.deleteDoNotContactsBySource(source='My DNC List 1').result()
