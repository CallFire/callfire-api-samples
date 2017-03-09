'strict'

const CallfireClient = require('callfire-api-client-js');
const client = new CallfireClient('api-login', 'api-password');

client.ready(() => {
    client.calls.getCallBroadcastBatches({
      id: 11646003,
      // search offset
      offset: 0,
      // return 10 items per request
      limit: 10,
      // return only specific fields
      fields: 'items(name,status,size,remaining)'
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
