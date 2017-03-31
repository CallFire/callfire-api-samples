from callfire.client import CallfireClient

client = CallfireClient('api-login', 'api-password')
client.contacts.updateDoNotContact(
    number='12132000381',
    body={
        'call': True,
        'text': False
    }
).result()
