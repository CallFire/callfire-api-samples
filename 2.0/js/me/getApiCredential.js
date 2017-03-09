'strict'

const CallfireClient = require('callfire-api-client-js');
const client = new CallfireClient('account-login', 'account-password');

client.ready(() => {
    client.me.getApiCredential({
      id: 379506003,
      // return only specific fields
      fields: 'name,enabled'
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
