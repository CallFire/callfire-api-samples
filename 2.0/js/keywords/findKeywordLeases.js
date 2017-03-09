'strict'

const CallfireClient = require('callfire-api-client-js');
const client = new CallfireClient('api-login', 'api-password');

client.ready(() => {
    client.keywords.findKeywordLeases({
      // search offset
      offset: 0,
      // return 10 items per request
      limit: 10,
      // return only specific fields
      fields: 'items(keyword,leaseBegin,leaseEnd)'
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
