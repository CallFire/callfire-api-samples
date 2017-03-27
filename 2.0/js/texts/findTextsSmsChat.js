'strict'

const CallfireClient = require('callfire-api-client-js');
const client = new CallfireClient('api-login', 'api-password');

client.ready(() => {
    client.texts.findTexts({
      // filter by fromNumber
      fromNumber: '12135551100',
      // filter by time interval
      intervalBegin: 1473781817000,
      // filter by time interval
      intervalEnd: 1473781917000,
      // start from 100' item
      offset: 100,
      // return 50 items per request
      limit: 50,
      // return only specific fields
      fields: 'items(id,message,created)'
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
