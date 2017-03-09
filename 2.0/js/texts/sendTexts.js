'strict'

const CallfireClient = require('callfire-api-client-js');
const client = new CallfireClient('api-login', 'api-password');

client.ready(() => {
    client.texts.sendTexts({
      // default message for recipients w/o TextRecipient.message field
      defaultMessage: 'Hello!',
      // specify a campaignId to send texts through a previously created campaign
      // campaignId: 4050600003
      body: [
        {
          phoneNumber: '12135551122',
          message: 'Hello World!'
        },
        // use an existing contact in CallFire account
        {contactId: 122460000043},
        {
          phoneNumber: '12135558090',
          attributes: {
            custom_external_id: 30005044,
            custom_name: 'Alice'
          },
          message: 'Hello, ${custom_name}!'
        },
      ]
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
