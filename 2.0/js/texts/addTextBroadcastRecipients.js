'strict'

const CallfireClient = require('callfire-api-client-js');
const client = new CallfireClient('api-login', 'api-password');

client.ready(() => {
    client.texts.addTextBroadcastRecipients({
      id: 11646003,
      body: [
        {phoneNumber: '12135551122'},
        // use an existing contact in CallFire account
        {contactId: 122460000043},
        {
          phoneNumber: '12135558090',
          attributes: {
            custom_external_id: 30005044,
            custom_property_1: 'value1'
          }
        },
      ]
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
