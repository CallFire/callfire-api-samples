'strict'

const CallfireClient = require('callfire-api-client-js');
const client = new CallfireClient('api-login', 'api-password');


client.ready(() => {
    client.media.findMedia({
    filter:'image1.jpeg'
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