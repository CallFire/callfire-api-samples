from callfire.client import CallfireClient

client = CallfireClient('api-login', 'api-password')
response = client.campaigns.findCampaignSounds(
    # filter by sound name
    filter='name',
    # includes ARCHIVED sounds
    includeArchived=True,
    # includes UPLOAD/RECORDING
    includePending=True,
    # includes SCRUBBED sounds
    includeScrubbed=True,
    # search offset
    offset=0,
    # return 10 items per request
    limit=10,
    # return only specific fields
    fields='items(id,name,callback)'
).result()

# see sample JSON response for this API
# on 'curl' samples tab
print(response)
