from callfire.client import CallfireClient

client = CallfireClient('api-login', 'api-password')
response = client.numbers.getNumberLeaseConfig(
    number='12132000384',
    # return only specific fields
    fields='number,configType'
).result()

# see sample JSON response for this API
# on 'curl' samples tab
print(response)
