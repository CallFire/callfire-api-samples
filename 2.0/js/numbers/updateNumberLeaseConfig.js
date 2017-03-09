'strict'

const CallfireClient = require('callfire-api-client-js');
const client = new CallfireClient('api-login', 'api-password');

client.ready(() => {
    client.numbers.updateNumberLeaseConfig({
      number: '19206596476',
      body: {
        configType: 'TRACKING',
        callTrackingConfig: {
          screen: false,
          recorded: true,
          voicemail: true,
          introSoundId: 10004001,
          whisperSoundId: 10005002,
          voicemailSoundId: 10006003,
          failedTransferSoundId: 10007004,
          transferNumbers: [
            '12135551122',
            '12135551189'
          ],
          weeklySchedule: {
            startTimeOfDay: {
              hour: 10,
              minute: 0,
              second: 0
            },
            stopTimeOfDay: {
              hour: 18,
              minute: 0,
              second: 0
            },
            daysOfWeek: [
              'MONDAY',
              'TUESDAY',
              'WEDNESDAY',
              'THURSDAY',
              'FRIDAY',
            ],
            timeZone: 'America/New_York'
          },
          googleAnalytics: {
            domain: 'domain - name',
            googleAccountId: 'UA - XXXXX - 2X',
            category: 'Sales'
          }
        }
      }
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
