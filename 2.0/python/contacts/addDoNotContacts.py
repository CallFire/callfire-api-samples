from callfire.client import CallfireClient

client = CallfireClient('api-login', 'api-password')
response = client.contacts.addDoNotContacts(
    id=45006708003,
    body={
        'source': 'My DNC list 1',
        'call': True,
        'text': True,
        'numbers': [
            '12132000381',
            '12132000382',
            '12132000383'
        ]
    }
).result()

# see sample JSON response for this API
# on 'curl' samples tab
print(response)
