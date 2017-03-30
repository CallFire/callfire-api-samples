from callfire.client import CallfireClient

client = CallfireClient('api-login', 'api-password')
response = client.numbers.findNumbersTollfree(
    # filter toll free numbers by prefix, pattern must be 3 char long and should end with '*'.
    # examples: 8**, 85*, 87* (but 855 will fail because pattern must end with '*').
    pattern='87*',
    # return 10 items per request
    limit=10,
    # return only specific fields
    fields='number'
).result()

# see sample JSON response for this API
# on 'curl' samples tab
print(response)
