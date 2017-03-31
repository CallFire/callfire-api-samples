from callfire.client import CallfireClient

client = CallfireClient('api-login', 'api-password')
response = client.contacts.getUniversalDoNotContacts(
    # a required destination phone number in E.164 format (11-digit)
    toNumber='12135551126',
    # an optional destination/source number for DNC, specified in E.164 format (11-digit)
    fromNumber='12130021127',
    # return only specific fields
    fields='toNumber,inboundCall,outboundCall'
).result()

# see sample JSON response for this API
# on 'curl' samples tab
print(response)
