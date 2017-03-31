from callfire.client import CallfireClient

client = CallfireClient('api-login', 'api-password')
response = client.texts.addTextBroadcastRecipients(
    id=11646003,
    body=[
        {'phoneNumber': '12135551122'},
        # use an existing contact in CallFire account
        {'contactId': 122460000043},
        {
            'phoneNumber': '12135558090',
            'attributes': {
                'custom_external_id': 30005044,
                'custom_property_1': 'value1'
            }
        },
    ]
).result()

# see sample JSON response for this API
# on 'curl' samples tab
print(response)