'strict'

const CallfireClient = require('callfire-api-client-js');
const client = new CallfireClient('api-login', 'api-password');

client.ready(() => {
    client.texts.createTextBroadcast({
      // set start parameter to run broadcast immediately
      // start: true,
      body: {
        name: 'Charity SMS Campaign',
        labels: [
          'charity',
          'id-10003'
        ],
        fromNumber: '19206596476',
        recipients: [
          {
            phoneNumber: '13233834422',
            attributes: {
              u_name: 'Alice',
              age: 30
            }
          },
          {
            phoneNumber: '13233834433',
            attributes: {
              u_name: 'Mark',
              age: 45
            }
          },
          {
            phoneNumber: '13233834488',
            message: 'Hi ${u_name}, the megic number is ${magic_number}',
            attributes: {
              u_name: 'Jane',
              magic_number: 10
            }
          }
        ],
        message: 'Hello {u_name} ...'
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
