'strict'

const CallfireClient = require('callfire-api-client-js');
const client = new CallfireClient('api-login', 'api-password');

client.ready(() => {
    client.calls.getCallRecordingMp3({id: 379506003})
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
