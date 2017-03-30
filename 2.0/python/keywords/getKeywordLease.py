from callfire.client import CallfireClient

client = CallfireClient('api-login', 'api-password')
response = client.keywords.getKeywordLease(
    keyword='SUN',
    # return only specific fields
    fields='items(keyword,leaseBegin,leaseEnd)'
).result()

print(response)
