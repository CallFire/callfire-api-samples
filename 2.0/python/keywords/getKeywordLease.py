from callfire.client import CallfireClient

client = CallfireClient('api-login', 'api-password')
response = client.keywords.getKeywordLease(
    keyword='SUN',
    # return only specific fields
    fields='items(keyword,leaseBegin,leaseEnd)'
).result()

# see sample JSON response for this API
# on 'curl' samples tab
print(response)