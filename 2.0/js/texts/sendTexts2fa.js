'strict'

const CallfireClient = require('callfire-api-client-js');
const client = new CallfireClient('api-login', 'api-password');

client.ready(() => {
    client.texts.sendTexts({
      body: [
        {
          phoneNumber: '12135551100',
          message: 'Your one-time code is 2517',
          attributes: {
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
