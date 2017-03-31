from callfire.client import CallfireClient

client = CallfireClient('api-login', 'api-password')
response = client.calls.sendCalls(
    # default voice for recipients w/o CallRecipient.voice field
    defaultVoice='MALE1',
    # specify a campaignId to send calls through a previously created campaign
    # campaignId= 4050600003
    # return particular fields in response
    fields='items(id,state,toNumber)',
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