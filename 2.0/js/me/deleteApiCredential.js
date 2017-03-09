'strict'

const CallfireClient = require('callfire-api-client-js');
const client = new CallfireClient('account-login', 'account-password');

client.ready(() => {
    client.me.deleteApiCredential({id: 425836003})
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
