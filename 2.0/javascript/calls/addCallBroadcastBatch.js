'strict'

const CallfireClient = require('callfire-api-client-js');
const client = new CallfireClient('api-login', 'api-password');

client.ready(() => {
    client.calls.addCallBroadcastBatch({
      id: 11646003,
      body: {
        name: 'contact batch for call broadcast',
        recipients: [
          {phoneNumber: '12135551122'},
          {phoneNumber: '12135553434'},
          {
            phoneNumber: '12135558090',
            attributes: {
              custom_external_id: 30005044,
              custom_property_1: 'value1'
            }
          },
        ],
        // or you can add contacts from particular contact list
        // contactListId: 70055003,
        scrubDuplicates: true
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
