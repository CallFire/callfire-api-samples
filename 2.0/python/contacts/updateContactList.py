from callfire.client import CallfireClient

client = CallfireClient('api-login', 'api-password')
client.contacts.updateContactList(
    id=11646003,
    body={
        'name': 'contact list updated'
    }
).result()
