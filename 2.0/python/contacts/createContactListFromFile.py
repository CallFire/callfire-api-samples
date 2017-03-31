from callfire.client import CallfireClient

client = CallfireClient('api-login', 'api-password')
response = client.contacts.createContactListFromFile(
    name='My Contact List',
    file=open('contacts.csv', 'r')
).result()

# see sample JSON response for this API
# on 'curl' samples tab
print(response)
