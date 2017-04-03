from callfire.client import CallfireClient

client = CallfireClient('api-login', 'api-password')
response = client.texts.createTextBroadcast(
    # set start parameter to run broadcast immediately
    # start: true,
    body={
        'name': 'Charity SMS Campaign',
        'labels': [
            'charity',
            'id-10003'
        ],
        'fromNumber': '19206596476',
        'recipients': [
            {
                'phoneNumber': '13233834422',
                'attributes': {
                    'u_name': 'Alice',
                    'age': 30
                }
            },
            {
                'phoneNumber': '13233834433',
                'attributes': {
                    'u_name': 'Mark',
                    'age': 45
                }
            },
            {
                'phoneNumber': '13233834488',
                'message': 'Hi ${u_name}, the megic number is ${magic_number}',
                'attributes': {
                    'u_name': 'Jane',
                    'magic_number': 10
                }
            }
        ],
        'message': 'Hello {u_name} ...'
    }
).result()

# see sample JSON response for this API
# on 'curl' samples tab
print(response)
