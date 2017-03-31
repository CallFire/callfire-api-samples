from callfire.client import CallfireClient

client = CallfireClient('api-login', 'api-password')
client.contacts.removeContactListItems(
    # contact list id
    id=11646003,
    # array of contact ids to remove
    contactId=[22277003, 23377003]
).result()
