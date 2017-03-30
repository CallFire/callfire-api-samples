from callfire.client import CallfireClient

client = CallfireClient('api-login', 'api-password')
response = client.numbers.getNumberLease(
    number='12132000384',
    # return only specific fields
    fields='number,nationalFormat,leaseBegin,leaseEnd,region/city'
).result()

# see sample JSON response for this API
# on 'curl' samples tab
print(response)
