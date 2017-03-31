from callfire.client import CallfireClient

client = CallfireClient('api-login', 'api-password')
response = client.texts.sendTexts(
    body=[
        {
            'phoneNumber': '12135551100',
            'message': 'Hello ${contact_name}, you have an appointment with Dr. Andrew tomorrow at 3:00 PM, if you need to reschedule please call (855)-555-4477',
            'attributes': {
                'contact_name': 'Alice',
                'external_user_id': '45450007002'
            }
        }
    ]
).result()

# see sample JSON response for this API
# on 'curl' samples tab
print(response)