'strict'

const CallfireClient = require('callfire-api-client-js');
const client = new CallfireClient('api-login', 'api-password');

client.ready(() => {
    client.calls.getCallRecordings({
      id: 379506003,
      // return only specific fields
      fields: 'items(callId,campaignId,lengthInBytes,mp3Url)'
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
