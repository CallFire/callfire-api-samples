'strict'

const CallfireClient = require('callfire-api-client-js');
const client = new CallfireClient('api-login', 'api-password');

client.ready(() => {
    client.contacts.createContacts({
      body: [
        {
          firstName: 'Alice',
          lastName: 'Moore',
          homePhone: '12135551126',
          mobilePhone: '12136666123',
          workPhone: '14553327789',
          zipcode: '40460',
          properties: {
            custom_ext_system_id: 100200301
          }
        },
        {
          firstName: 'Bob',
          lastName: 'Smith',
          homePhone: '12135551127',
          properties: {
            custom_age: 30,
            custom_position: 'Manager'
          }
        }
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
