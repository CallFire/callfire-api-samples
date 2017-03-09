'strict'

const CallfireClient = require('callfire-api-client-js');
const client = new CallfireClient('api-login', 'api-password');

client.ready(() => {
    client.calls.getCallBroadcastStats({
      id: 11646003,
      // filter by time interval
      begin: 1473781817000,
      // filter by time interval
      end: 1473781817000,
      // return only specific fields
      fields: 'totalOutboundCount,billedAmount,callsAttempted'
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
