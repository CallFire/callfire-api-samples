'strict'

const CallfireClient = require('callfire-api-client-js');
const client = new CallfireClient('api-login', 'api-password');

client.ready(() => {
    client.calls.updateCallBroadcast({
      id: 11646003,
      body: {
        name: 'Call Broadcast with Schedules',
        answeringMachineConfig: 'LIVE_IMMEDIATE',
        sounds: {
          liveSoundText: 'Hello! This is an updated Call Broadcast config tts'
        },
        schedules: [
          {
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
              'SATURDAY',
              'SUNDAY'
            ],
            timeZone: 'America/New_York',
            startDate: {
              year: 2016,
              month: 12,
              day: 1
            },
            stopDate: {
              year: 2016,
              month: 12,
              day: 10
            }
          }]
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
