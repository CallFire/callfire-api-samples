from callfire.client import CallfireClient

client = CallfireClient('api-login', 'api-password')
response = client.calls.findCalls(
    # filter by call ids
    id=[
        11646003,
        12646003,
        13776003
    ],
    # specify  id of a campaign, queries for calls inside a particular campaign.
    # do not set to list calls of all campaigns or 0 for a default campaign
    campaignId=449060003,
    # queries for calls which are used in the particular contact batch
    batchId=447060003,
    # filter by fromNumber
    fromNumber='12135551126',
    # filter by toNumber
    toNumber='12136666123',
    # filter by label
    label='my label',
    # filter by call state
    states='READY,FINISHED,INVALID',
    # filter by call result
    results='SENT',
    # filter only inbound actions
    inbound=False,
    # filter by time interval
    intervalBegin=1473781817000,
    # filter by time interval
    intervalEnd=1473781817000,
    # search offset
    offset=0,
    # return 10 items per request
    limit=10,
    # return only specific fields
    fields='items(id,fromNumber,toNumber,modified,finalCallResult)'
).result()

# see sample JSON response for this API
# on 'curl' samples tab
print(response)