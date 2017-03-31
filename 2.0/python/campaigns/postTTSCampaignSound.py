from callfire.client import CallfireClient

client = CallfireClient('api-login', 'api-password')
response = client.campaigns.postTTSCampaignSound(
    body={
        'voice': 'MALE1',
        'message': 'This is a TTS sound'
    }
).result()

# see sample JSON response for this API
# on 'curl' samples tab
print(response)
