from callfire.client import CallfireClient

client = CallfireClient('api-login', 'api-password')
response = client.campaigns.postCallCampaignSound(
    body={
        'name': 'Sound 1',
        'toNumber': '12135551122'
    }
).result()

# see sample JSON response for this API
# on 'curl' samples tab
print(response)
