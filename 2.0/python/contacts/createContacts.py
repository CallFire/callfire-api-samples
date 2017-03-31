from callfire.client import CallfireClient

client = CallfireClient('api-login', 'api-password')
response = client.contacts.createContacts(
    body=[
        {
            'firstName': 'Alice',
            'lastName': 'Moore',
            'homePhone': '12135551126',
            'mobilePhone': '12136666123',
            'workPhone': '14553327789',
            'zipcode': '40460',
            'properties': {
                'custom_ext_system_id': 100200301
            }
        },
        {
            'firstName': 'Bob',
            'lastName': 'Smith',
            'homePhone': '12135551127',
            'properties': {
                'custom_age': 30,
                'custom_position': 'Manager'
            }
        }
    ]
).result()

# see sample JSON response for this API
# on 'curl' samples tab
print(response)
