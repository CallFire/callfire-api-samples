from callfire.client import CallfireClient

client = CallfireClient('api-login', 'api-password')
client.contacts.deleteDoNotContact(number='12135551126,12136666123').result()
