'strict'

const CallfireClient = require('callfire-api-client-js');
const client = new CallfireClient('api-login', 'api-password');

client.ready(() => {
    client.campaigns.findCampaignSounds({
      // filter by sound name
      filter: 'name',
      // includes ARCHIVED sounds
      includeArchived: true,
      // includes UPLOAD/RECORDING
      includePending: true,
      // includes SCRUBBED sounds
      includeScrubbed: true,
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
      .catch(function (err) {
        console.log('request error ' + err.data);
      });
  },
  (clientError) => {
    console.log('client error ' + clientError);
  }
);
