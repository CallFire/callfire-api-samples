'strict'

const fs = require('fs');
const CallfireClient = require('callfire-api-client-js');
const client = new CallfireClient('api-login', 'api-password');

client.ready(() => {
    client.media.createMedia({
      name: 'my-file',
      // for nodejs environment
      // file: fs.createReadStream('./myfile.wav')
      // for browser environment
      // file: new Blob([/* binary data */], {type: 'audio/wav'})
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
