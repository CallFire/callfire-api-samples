from callfire.client import CallfireClient

client = CallfireClient('api-login', 'api-password')
response = client.calls.addCallBroadcastBatch(
    id=11646003,
    body={
        'name': 'contact batch for call broadcast',
        'recipients': [
            {'phoneNumber': '12135551122'},
            {'phoneNumber': '12135553434'},
            {
                'phoneNumber': '12135558090',
                'attributes': {
                    'custom_external_id': 30005044,
                    'custom_property_1': 'value1'
                }
            }
        ],
        # or you can add contacts from particular contact list
        # contactListId: 70055003,
        'scrubDuplicates': True
    }
).result()

# see sample JSON response for this API
# on 'curl' samples tab
print(response)
