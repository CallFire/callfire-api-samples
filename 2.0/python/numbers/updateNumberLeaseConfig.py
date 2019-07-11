from callfire.client import CallfireClient

client = CallfireClient('api-login', 'api-password')
client.numbers.updateNumberLeaseConfig(
    number='19206596476',
    body={
        'configType': 'TRACKING',
        'callTrackingConfig': {
            'screen': False,
            'recorded': True,
            'voicemail': True,
            'introSoundId': 10004001,
            'whisperSoundId': 10005002,
            'voicemailSoundId': 10006003,
            'failedTransferSoundId': 10007004,
            'transferNumbers': [
                '12135551122',
                '12135551189'
            ],
            'weeklySchedule': {
                'startTimeOfDay': {
                    'hour': 10,
                    'minute': 0,
                    'second': 0
                },
                'stopTimeOfDay': {
                    'hour': 18,
                    'minute': 0,
                    'second': 0
                },
                'daysOfWeek': [
                    'MONDAY',
                    'TUESDAY',
                    'WEDNESDAY',
                    'THURSDAY',
                    'FRIDAY',
                ],
                'timeZone': 'America/New_York'
            },
            'googleAnalytics': {
                'domain': 'domain - name',
                'googleAccountId': 'UA - XXXXX - 2X',
                'category': 'Sales'
            }
        }

        # depends on what type of configuration your need assign TRACKING or IVR config
        # body={
        #    'configType': 'IVR',
        #    'ivrInboundConfig': {
        #       'dialplanXml': '<dialplan name="Root"> <menu maxDigits="1" timeout="3500" name="Live"> <play type="tts" voice="female1"> Hello this is AB Advertising, please press 1 to transfer to our sales repreentative, press 2 to contact clients support. </play> <keypress pressed="1"> <stash varname="selected_menu">sales</stash> <play type="tts" voice="female1"> You will be transferred to sales representative in a moment. Please wait. </play> <transfer callerid="${call.callerid}" musiconhold="blues" mode="ringall"> 15550004455 </transfer> </keypress> <keypress pressed="2" name="kp_become_volonteer"> <stash varname="selected_menu">sales</stash> <play type="tts" voice="female1"> You will be transferred to clients support. Please wait. </play> <transfer callerid="${call.callerid}" musiconhold="blues" mode="ringall"> 15550005500 </transfer> </keypress> <keypress pressed="default" name="incorrect_Selection"> <play type="tts" voice="female1">That is not a valid selection. Please try again.</play> <goto name="replay_Live">Live</goto> </keypress> </menu> <play type="tts" voice="female1"> Thank you for calling us. Have a good day. </play> <hangup name="Hangup"/> </dialplan> '
        #    }
        # }
    }
).result()
