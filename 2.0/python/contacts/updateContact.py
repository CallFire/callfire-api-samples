from callfire.client import CallfireClient

client = CallfireClient('api-login', 'api-password')
client.contacts.updateContact(
    id=11646003,
    body={
        'mobilePhone': '12136600123',
        'workPhone': '14553320089',
    }
).result()
