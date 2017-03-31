from callfire.client import CallfireClient

client = CallfireClient('api-login', 'api-password')
response = client.calls.createCallBroadcast(
    body={
        'name': 'Charity Campaign',
        'fromNumber': '12135551189',
        'labels': [
            'charity',
            'id-10002'
        ],
        'localTimeRestriction': {
            'beginHour': 9,
            'beginMinute': 0,
            'endHour': 18,
            'endMinute': 0
        },
        'schedules': [
            {
                'startTimeOfDay': {
                    'hour': 10,
                    'minute': 0,
                    'second': 0
                },
                'daysOfWeek': [
                    'MONDAY',
                    'WEDNESDAY'
                ],
                'timeZone': 'America/New_York',
                'startDate': {
                    'year': 2016,
                    'month': 12,
                    'day': 1
                }
            }
        ],
        'retryConfig': {
            'maxAttempts': 2,
            'minutesBetweenAttempts': 5,
            'retryResults': [
                'BUSY',
                'NO_ANS'
            ],
            'retryPhoneTypes': [
                'MOBILE_PHONE',
                'WORK_PHONE'
            ]
        },
        'recipients': [
            {
                'phoneNumber': '12135551100',
                'attributes': {
                    'age': 30,
                    'position': 'Manager'
                }
            },
            {
                'phoneNumber': '12135771188',
                'attributes': {
                    'external_system_id': 34347770001,
                    'call_label': 'friends'
                }
            },
            {
                'contactId': 46000044001
            }
        ],
        'dialPlanXml': '<dialplan name=\"Root\"> <!-- answering machine detection --> <amd> <!-- if call is answered by human go to live menu --> <live> <goto name=\"goto_Live\">Live</goto> </live> <machine> <goto name=\"goto_Machine\">Machine</goto> </machine> </amd> <menu maxDigits=\"1\" timeout=\"3500\" name=\"Live\"> <play type=\"tts\" voice=\"female1\" name=\"play_Live\"> Hello ${contact.firstName}, we are organizing a charity weekend in November. Do not miss to visit it. Press \"1\" to follow the instructions how to order the tickets, press \"2\" if you are willing to become a volunteer at event. </play> <keypress pressed=\"1\" name=\"kp_order_tickets\"> <!-- store recipients answer and go to another menu to make a purchase --> <stash varname=\"order\" name=\"create_an_order\">Yes</stash> <goto>order_tickets</goto> </keypress> <keypress pressed=\"2\" name=\"kp_become_volonteer\"> <!-- store recipients answer --> <stash varname=\"volonteer\" name=\"become_volonteer\">Yes</stash> <play type=\"tts\" voice=\"female1\" name=\"play_Goodbye_1\">Thanks for the response. We will call you later today.</play> <goto>Hangup</goto> </keypress> <!-- if pressed key is not specified in menu replay Live menu --> <keypress pressed=\"default\" name=\"incorrect_Selection\"> <play type=\"tts\" voice=\"female1\" name=\"play_Inorrect_Selection\">That is not a valid selection. Please try again.</play> <goto name=\"replay_Live\">Live</goto> </keypress> </menu> <menu maxDigits=\"1\" timeout=\"3500\" name=\"order_tickets\"> <play type=\"tts\" voice=\"female1\" name=\"play_order_tickets\"> You will be transferred to Sales representative in a moment. Please wait. </play> <transfer callerid=\"${call.callerid}\" musiconhold=\"blues\" mode=\"ringall\"> 15551234567 </transfer> </menu> <play type=\"tts\" voice=\"female1\" name=\"Goodbye\"> Thank you for taking our survey </play> <goto name=\"Goodbye_Hangup\">Hangup</goto> <play type=\"tts\" voice=\"female1\" name=\"Machine\"> Hello ${contact.firstName} ${contact.lastName}. We are organizing a charity weekend in November. If you would like to participate, please call 8 5 5, 5 5 5, 5 5 5 5. Thank you. </play> <hangup name=\"Hangup\"/> </dialplan>'
    }
).result()

# see sample JSON response for this API
# on 'curl' samples tab
print(response)