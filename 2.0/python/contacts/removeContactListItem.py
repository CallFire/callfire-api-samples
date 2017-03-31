from callfire.client import CallfireClient

client = CallfireClient('api-login', 'api-password')
client.contacts.removeContactListItem(
    # contact list id
    id=11646003,
    # contact id to remove
    contactId=22277003
).result()
