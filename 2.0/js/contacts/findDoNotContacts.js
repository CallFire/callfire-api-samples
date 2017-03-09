'strict'

const CallfireClient = require('callfire-api-client-js');
const client = new CallfireClient('api-login', 'api-password');

client.ready(() => {
    client.contacts.findDoNotContacts({
      // filter by Prefix (1-10 digits) of phone numbers
      prefix: '1424',
      // find DNCs by specified phone numbers
      number: ['12135551126', '12136666123'],
      // filter by campaign
      campaignId: 11646003,
      // filter by DNC source
      source: 'my source',
      // filter by call feature
      call: true,
      // filter by text feature
      text: true,
      // search offset
      offset: 0,
      // return 10 items per request
      limit: 10,
      // return only specific fields
      fields: 'items(number,call)'
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
