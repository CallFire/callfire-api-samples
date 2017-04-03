from callfire.client import CallfireClient

client = CallfireClient('api-login', 'api-password')
response = client.texts.sendTexts(
    body=[
        {
            'phoneNumber': '12135551100',
            'message': 'Your one-time code is 2517',
            'attributes': {
                'external_user_id': '45450007002'
            }
        }
    ]
).result()

# see sample JSON response for this API
# on 'curl' samples tab
print(response)
