'strict'

const CallfireClient = require('callfire-api-client-js');
const client = new CallfireClient('api-login', 'api-password');

client.ready(() => {
    client.calls.sendCalls({
      body: [
        {
          phoneNumber: '12135551100',
          attributes: {
            external_user_id: '45450007002'
          },
          dialplanXml: '<dialplan name="Root"> <menu maxDigits="1" timeout="3500" name="Live"> <play type="tts" voice="female1"> Hello, this is UMM Health Center, you have an appointment with Dr. Andrew tomorrow at 3:00 PM, please press 1 to confirm the time or press 2 to reschedule appointment. </play> <keypress pressed="1"> <stash varname="selected_menu">confirmed</stash> <goto>bye_tts</goto> </keypress> <keypress pressed="2"> <stash varname="selected_menu">reschedule</stash> <play type="tts" voice="female1"> You will be transferred to our representative to reschedule an appointment. Please wait. </play> <transfer callerid="${call.callerid}" musiconhold="blues" mode="ringall"> 15550005500 </transfer> </keypress> <keypress pressed="default" name="incorrect_Selection"> <play type="tts" voice="female1">That is not a valid selection. Please try again.</play> <goto name="replay_Live">Live</goto> </keypress> </menu> <play type="tts" voice="female1" name="bye_tts"> Thank you for your response. Have a good day. </play> <hangup name="Hangup"/> </dialplan> '
        }
      ]
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
