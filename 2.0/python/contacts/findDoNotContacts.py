from callfire.client import CallfireClient

client = CallfireClient('api-login', 'api-password')
response = client.contacts.findDoNotContacts(
    # filter by Prefix (1-10 digits) of phone numbers
    prefix='1424',
    # find DNCs by specified phone numbers
    number=['12135551126', '12136666123'],
    # filter by campaign
    campaignId=11646003,
    # filter by DNC source
    source='my source',
    # filter by call feature
    call=True,
    # filter by text feature
    text=True,
    # search offset
    offset=0,
    # return 10 items per request
    limit=10,
    # return only specific fields
    fields='items(number,call)'
).result()

# see sample JSON response for this API
# on 'curl' samples tab
print(response)
