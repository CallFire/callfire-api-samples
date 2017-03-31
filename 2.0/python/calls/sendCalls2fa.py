from callfire.client import CallfireClient

client = CallfireClient('api-login', 'api-password')
response = client.calls.sendCalls(
    body=[
        {
            'phoneNumber': '12135551100',
            'attributes': {
                'external_user_id': '45450007002'
            },
            'dialplanXml': '<dialplan name=\"Root\"> <amd> <live> <goto>live</goto> </live> <machine> <goto>hangup</goto> </machine> </amd> <menu maxDigits=\"1\" timeout=\"3500\" name=\"live\"> <play type=\"tts\" voice=\"female1\" name=\"play_code\">Hello, your one-time code is 2 5 1 7, press 1 to repeat.</play> <keypress pressed=\"1\"> <goto>live</goto> </keypress> <keypress pressed=\"timeout\"> <hangup/> </keypress> </menu> <hangup name=\"hangup\"/> </dialplan>'
        }
    ]
).result()

# see sample JSON response for this API
# on 'curl' samples tab
print(response)