from callfire.client import CallfireClient

client = CallfireClient('api-login', 'api-password')
response = client.campaigns.getCampaignSound(
    id=379506003,
    # return only specific fields
    fields='name,lengthInSeconds'
).result()

# see sample JSON response for this API
# on 'curl' samples tab
print(response)
