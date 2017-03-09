'strict'

const CallfireClient = require('callfire-api-client-js');
const client = new CallfireClient('api-login', 'api-password');

client.ready(() => {
    client.calls.findCalls({
      // filter by call ids
      id: [
        11646003,
        12646003,
        13776003
      ],
      // specify  id of a campaign, queries for calls inside a particular campaign.
      // do not set to list calls of all campaigns or 0 for a default campaign
      campaignId: 449060003,
      // queries for calls which are used in the particular contact batch
      batchId: 447060003,
      // filter by fromNumber
      fromNumber: '12135551126',
      // filter by toNumber
      toNumber: '12136666123',
      // filter by label
      label: 'my label',
      // filter by call state
      states: 'READY,FINISHED,INVALID',
      // filter by call result
      results: 'SENT',
      // filter only inbound actions
      inbound: false,
      // filter by time interval
      intervalBegin: 1473781817000,
      // filter by time interval
      intervalEnd: 1473781817000,
      // search offset
      offset: 0,
      // return 10 items per request
      limit: 10,
      // return only specific fields
      fields: 'items(id,fromNumber,toNumber,modified,finalCallResult)'
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
