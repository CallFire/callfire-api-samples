from callfire.client import CallfireClient

client = CallfireClient('api-login', 'api-password')
response = client.calls.addCallBroadcastBatch(
    id=11646003,
    body={
        'name': 'Contact Batch 1',
        'contactListId': 300555001,
        'scrubDuplicates': True
    }
).result()

# see sample JSON response for this API
# on 'curl' samples tab
print(response)