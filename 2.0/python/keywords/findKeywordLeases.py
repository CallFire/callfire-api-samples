from callfire.client import CallfireClient

client = CallfireClient('api-login', 'api-password')
response = client.keywords.findKeywordLeases(
    # search offset
    offset=0,
    # return 10 items per request
    limit=10,
    # return only specific fields
    fields='items(keyword,leaseBegin,leaseEnd)'
).result()

print(response)
