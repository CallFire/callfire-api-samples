'strict'

const CallfireClient = require('callfire-api-client-js');
const client = new CallfireClient('api-login', 'api-password');

client.ready(() => {
    client.calls.sendCalls({
      body: [
        {
          phoneNumber: '12135551100',
          liveMessage: 'Hello, Alice, this is message for live answer',
          machineMessage: 'Hello, Alice, this is message for answering machine'
        },
        {
          phoneNumber: '12135551101',
          liveMessage: 'Hello, Bob, this is message for live answer',
          machineMessage: 'Hello, Bob, this is message for answering machine'
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
