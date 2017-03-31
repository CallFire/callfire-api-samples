from callfire.client import CallfireClient

client = CallfireClient('api-login', 'api-password')
response = client.calls.sendCalls(
    body=[
        {
            'phoneNumber': '12135551100',
            'liveMessage': 'Hello, Alice, this is message for live answer',
            'machineMessage': 'Hello, Alice, this is message for answering machine'
        },
        {
            'phoneNumber': '12135551101',
            'liveMessage': 'Hello, Bob, this is message for live answer',
            'machineMessage': 'Hello, Bob, this is message for answering machine'
        }
    ]
).result()

# see sample JSON response for this API
# on 'curl' samples tab
print(response)