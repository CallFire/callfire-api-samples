'strict'

const CallfireClient = require('callfire-api-client-js');
const client = new CallfireClient('api-login', 'api-password');

client.ready(() => {
    client.calls.createCallBroadcast({
      // set start parameter to run broadcast immediately
      // start: true,
      body: {
        name: 'Political Campaign',
        fromNumber: '12135551189',
        labels: [
          'political-poll',
          'id-10002'
        ],
        localTimeRestriction: {
          beginHour: 9,
          beginMinute: 0,
          endHour: 18,
          endMinute: 0
        },
        retryConfig: {
          maxAttempts: 2,
          minutesBetweenAttempts: 5,
          retryResults: [
            'BUSY',
            'NO_ANS'
          ],
          retryPhoneTypes: [
            'MOBILE_PHONE',
            'WORK_PHONE'
          ]
        },
        dialplanXml: '<dialplan name="Root"> <amd> <live> <goto name="goto_Live">Live</goto> </live> <machine> <goto name="goto_Machine">Machine</goto> </machine> </amd> <menu maxDigits="1" timeout="3500" name="Live"> <play type="tts" voice="female1" name="play_Live">Hello. This is a call for a short political poll for the upcoming election. Will you vote in the upcoming election? Press 1 for Yes, or 2 for No..</play> <keypress pressed="1" name="kp_Vote"> <stash varname="Vote" name="stash_Will_Vote">Yes</stash> <goto>Question_01</goto> </keypress> <keypress pressed="2" name="kp_Will_Not_Vote"> <stash varname="Vote" name="stash_Will_Not_Vote">No</stash> <play type="tts" voice="female1" name="play_Goodbye_1">Thank you for your time. Goodbye.</play> <goto>Hangup</goto> </keypress> <keypress pressed="default" name="incorrect_Selection"> <play type="tts" voice="female1" name="play_Inorrect_Selection">That is not a valid selection. Please try again.</play> <goto name="replay_Live">Live</goto> </keypress> </menu> <menu maxDigits="1" timeout="3500" name="Question_01"> <play type="tts" voice="female1" name="play_Question_01">Who will you vote for in the upcoming elections? Press 1 for Donkeys. Press 2 for Elephants. Press 3 for Greenies, press 4 for Undecided, or, press 5 for Decline to state.</play> <keypress pressed="1-5" name="Selection_Question_01"> <stash varname="Candidate" name="stash_Candidate">${call.lastinput}</stash> <goto name="goto_Goodbye">Goodbye</goto> </keypress> <keypress pressed="default" name="incorrect_Selection_Question_01"> <play type="tts" voice="female1" name="play_Inorrect_Selection_Question_01"> That is not a valid selection. Please try again. </play> <goto name="replay_Question_01">Question_01</goto> </keypress> </menu> <play type="tts" voice="female1" name="Goodbye"> Thank you for taking our poll. Please remember to vote in the upcoming election! Thank you for your time. Goodbye. </play> <goto name="Goodbye_Hangup">Hangup</goto> <play type="tts" voice="female1" name="Machine"> Hello. This is a call for a political poll for the upcoming election. Sorry we missed you. We will try you again later, or, if you would like to take this short poll, please call 8 5 5,5 5 5,5 5 5 5. Thank you.</play> <hangup name="Hangup"/> </dialplan> '

      }
    })
      .then((response) => {
        console.log(response.obj);
      })
      .catch((err) => {
        console.log('request error ' + err.data);
      });
  },
  (clientError) => {
    console.log('client error ' + clientError);
  }
);
