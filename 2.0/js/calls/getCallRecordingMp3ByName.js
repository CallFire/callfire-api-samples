'strict'

const CallfireClient = require('callfire-api-client-js');
const client = new CallfireClient('api-login', 'api-password');

client.ready(() => {
    client.calls.getCallRecordingMp3ByName({
      id: 379506003,
      name: 'call-recording1'
    })
      .then((response) => {
        // returns binary response
        console.log(response.data);
      })
      .catch((err) => {
        console.log('request error ' + err.data);
      });
  },
  (clientError) => {
    console.log('client error ' + clientError);
  }
);
