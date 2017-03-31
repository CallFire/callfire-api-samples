from callfire.client import CallfireClient

client = CallfireClient('api-login', 'api-password')
response = client.calls.createCallBroadcast(
    # set start parameter to run broadcast immediately
    # start: true,
    body={
        'name': 'Example API Call Broadcast',
        'fromNumber': '12135551189',
        'recipients': [
            {'phoneNumber': '2134441133'},
            {'phoneNumber': '2135551144'}
        ],
        'answeringMachineConfig': 'AM_AND_LIVE',
        'sounds': {
            'liveSoundText': 'Hello! This is a live answer text to speech recording',
            'machineSoundText': 'This is an answering machine text to speech recording'
        },
        'resumeNextDay': True
    }
).result()

# see sample JSON response for this API
# on 'curl' samples tab
print(response)