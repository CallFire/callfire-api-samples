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
          dialplanXml: '<dialplan name=\"Root\"> <amd> <live> <goto>live</goto> </live> <machine> <goto>hangup</goto> </machine> </amd> <menu maxDigits=\"1\" timeout=\"3500\" name=\"live\"> <play type=\"tts\" voice=\"female1\" name=\"play_msg\">Hello, ${contact.firstName}, this is CallFire IVR message.</play> <keypress pressed=\"1\"> <goto>live</goto> </keypress> <keypress pressed=\"timeout\"> <hangup/> </keypress> </menu> <hangup name=\"hangup\"/> </dialplan> '
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
