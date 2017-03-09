'strict'

const CallfireClient = require('callfire-api-client-js');
const client = new CallfireClient('api-login', 'api-password');

client.ready(() => {
    client.numbers.findNumbersLocal({
      // filter by 4-7 digit prefix
      prefix: '14245',
      // filter by city
      city: 'Los Angeles',
      // filter by state
      state: 'CA',
      // filter by zipcode
      zipcode: '90940',
      // filter by local access and transport area (LATA)
      lata: '123',
      // filter by rate center
      rateCenter: '123',
      // search offset
      offset: 0,
      // return 10 items per request
      limit: 10,
      // return only specific fields
      fields: 'items(number,nationalFormat,leaseBegin,leaseEnd,region/city)'
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
