'strict'

const CallfireClient = require('callfire-api-client-js');
const client = new CallfireClient('api-login', 'api-password');

client.ready(() => {
    client.contacts.addDoNotContacts({
      id: 45006708003,
      body: {
        source: 'My DNC list 1',
        call: true,
        text: true,
        numbers: [
          '12132000381',
          '12132000382',
          '12132000383'
        ]
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
