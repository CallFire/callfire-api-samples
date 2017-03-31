from callfire.client import CallfireClient

client = CallfireClient('api-login', 'api-password')
client.contacts.deleteContactList(id=11646003).result()
