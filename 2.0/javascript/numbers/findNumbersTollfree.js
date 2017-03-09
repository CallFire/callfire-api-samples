'strict'

const CallfireClient = require('callfire-api-client-js');
const client = new CallfireClient('api-login', 'api-password');

client.ready(() => {
    client.numbers.findNumbersTollfree({
      // filter toll free numbers by prefix, pattern must be 3 char long and should end with '*'.
      // examples: 8**, 85*, 87* (but 855 will fail because pattern must end with '*').
      pattern: '87*',
      // return 10 items per request
      limit: 10,
      // return only specific fields
      fields: 'number'
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
