from callfire.client import CallfireClient

client = CallfireClient('api-login', 'api-password')
client.campaigns.updateCampaignBatch(
    id=379506003,
    body={
        'enabled': True
    }
).result()
