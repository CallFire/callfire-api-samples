from callfire.client import CallfireClient

client = CallfireClient('api-login', 'api-password')
response = client.campaigns.postFileCampaignSound(
    file=open('sound1.mp3', 'rb')
).result()

# see sample JSON response for this API
# on 'curl' samples tab
print(response)
