'strict'

const CallfireClient = require('callfire-api-client-js');
const client = new CallfireClient('api-login', 'api-password');

client.ready(() => {
    client.contacts.getUniversalDoNotContacts({
      // a required destination phone number in E.164 format (11-digit)
      toNumber: '12135551126',
      // an optional destination/source number for DNC, specified in E.164 format (11-digit)
      fromNumber: '12130021127',
      // return only specific fields
      fields: 'toNumber,inboundCall,outboundCall'
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
