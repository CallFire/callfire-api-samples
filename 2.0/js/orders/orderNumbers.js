'strict'

const CallfireClient = require('callfire-api-client-js');
const client = new CallfireClient('api-login', 'api-password');

client.ready(() => {
    client.orders.orderNumbers({
      body: {
        // order particular numbers
        numbers: ['12131234567', '12131234568']
        // or find and order area-specific numbers
        // localCount: '2',
        // zipcode: '90401'
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
