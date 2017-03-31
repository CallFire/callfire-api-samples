from callfire.client import CallfireClient

client = CallfireClient('api-login', 'api-password')
response = client.campaigns.getCampaignSoundDataMp3(id=379506003).result()

# see sample JSON response for this API
# on 'curl' samples tab
print(response)
