'strict'

const CallfireClient = require('callfire-api-client-js');
const client = new CallfireClient('api-login', 'api-password');

client.ready(() => {
    client.texts.sendTexts({
      body: [
        {
          phoneNumber: '12135551100',
          message: 'Hello ${contact_name}, you have an appointment with Dr. Andrew tomorrow at 3:00 PM, if you need to reschedule please call (855)-555-4477',
          attributes: {
            contact_name: 'Alice',
            external_user_id: '45450007002'
          }
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
