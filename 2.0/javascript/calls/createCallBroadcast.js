'strict'

const CallfireClient = require('callfire-api-client-js');
const client = new CallfireClient('api-login', 'api-password');

client.ready(() => {
    client.calls.createCallBroadcast({
      // set start parameter to run broadcast immediately
      // start: true,
      body: {
        name: 'Example API Call Broadcast',
        fromNumber: '12135551189',
        recipients: [
          {phoneNumber: '2134441133'},
          {phoneNumber: '2135551133'}
        ],
        answeringMachineConfig: 'AM_AND_LIVE',
        sounds: {
          liveSoundText: 'Hello! This is a live answer text to speech recording',
          machineSoundText: 'This is an answering machine text to speech recording'
        },
        resumeNextDay: true
      }
    })
      .then((response) => {
        console.log(response.obj);
      })
      .catch(function (err) {
        console.log('request error ' + err.data);
      });
  },
  (clientError) => {
    console.log('client error ' + clientError);
  }
);
