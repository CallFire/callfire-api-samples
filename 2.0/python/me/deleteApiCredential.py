from callfire.client import CallfireClient

client = CallfireClient('account-login', 'account-password')
client.me.deleteApiCredential(id=425836003)
