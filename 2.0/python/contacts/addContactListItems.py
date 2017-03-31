from callfire.client import CallfireClient

client = CallfireClient('api-login', 'api-password')
response = client.contacts.addContactListItems(
    id=45006708003,
    body={
        # choose one of source of contacts: array of contact objects / existing contacts (ids) / array of numbers
        'contacts': [
            {
                'firstName': 'Alice',
                'lastName': 'Moore',
                'homePhone': '12135551126'
            },
            {
                'firstName': 'Bob',
                'lastName': 'Smith',
                'homePhone': '12135551127',
                'properties': {
                    'age': 30
                }
            }
        ],
        # add existing contacts to list
        # contactIds: [
        #   800634185003,
        #   800734186003,
        #   800834187003,
        #   800984185003
        # ],
        # add phone numbers to list
        # contactNumbers: [
        #   '12132212384',
        #   '12136612355',
        #   '12133312300'
        # ],
        # contactNumbersField: 'workPhone'
    }
).result()

# see sample JSON response for this API
# on 'curl' samples tab
print(response)
