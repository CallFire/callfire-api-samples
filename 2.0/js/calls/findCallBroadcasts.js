'strict'

const CallfireClient = require('callfire-api-client-js');
const client = new CallfireClient('api-login', 'api-password');

client.ready(() => {
    client.calls.findCallBroadcasts({
      // filter by name
      name: 'broadcast name',
      // filter by label
      label: 'my label',
      // filter only broadcasts in RUNNING state
      running: true,
      // search offset
      offset: 0,
      // return 10 items per request
      limit: 10,
      // return only specific fields
      fields: 'items(id,name,status,sounds)'
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
