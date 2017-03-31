from callfire.client import CallfireClient

client = CallfireClient('api-login', 'api-password')
response = client.contacts.findContacts(
    # find contacts with particular ids
    id=[11646003, 12646003, 13776003],
    # find contacts by specified phone numbers
    number=['12135551126', '12136666123'],
    # find contacts by contact list
    contactListId=14400809003,
    # find contacts by custom property name
    propertyName=14400809003,
    # find contacts by custom property value
    propertyValue=14400809003,
    # search offset
    offset=0,
    # return 10 items per request
    limit=10,
    # return only specific fields
    fields='items(id,name,size)'
).result()

# see sample JSON response for this API
# on 'curl' samples tab
print(response)
