'strict'

const CallfireClient = require('callfire-api-client-js');
const client = new CallfireClient('api-login', 'api-password');

client.ready(() => {
    client.webhooks.findWebhooks({
      // filter by webhook name
      name: 'my webhook',
      // filter by resource
      resource: 'TextBroadcast',
      // filter by event
      event: 'Started',
      // filter by callback URI
      callback: 'https://myservice/callback',
      // filter by enabled flag
      enabled: true,
      // search offset
      offset: 0,
      // return 10 items per request
      limit: 10,
      // return only specific fields
      fields: 'items(id,name,callback)'
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
