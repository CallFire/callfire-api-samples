'strict'

const CallfireClient = require('callfire-api-client-js');
const client = new CallfireClient('api-login', 'api-password');

client.ready(() => {
    client.contacts.findContacts({
      // find contacts with particular ids
      id: [11646003, 12646003, 13776003],
      // find contacts by specified phone numbers
      number: ['12135551126', '12136666123'],
      // find contacts by contact list
      contactListId: 14400809003,
      // find contacts by custom property name
      propertyName: 14400809003,
      // find contacts by custom property value
      propertyValue: 14400809003,
      // search offset
      offset: 0,
      // return 10 items per request
      limit: 10,
      // return only specific fields
      fields: 'items(id,name,size)'
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
