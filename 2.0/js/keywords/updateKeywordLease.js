'strict'

const CallfireClient = require('callfire-api-client-js');
const client = new CallfireClient('api-login', 'api-password');

client.ready(() => {
    client.keywords.updateKeywordLease({
      keyword: 'SUN',
      body: {
        autoRenew: false
      }
    })
      .then((response) => {
        console.log(response.data);
      })
      .catch((err) => {
        console.log('request error ' + err.data);
      });
  },
  (clientError) => {
    console.log('client error ' + clientError);
  }
);
