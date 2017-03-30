from callfire.client import CallfireClient

client = CallfireClient('api-login', 'api-password')
response = client.orders.getOrder(
    id=379506003,
    # return only specific fields
    fields='status,totalCost'
).result()

print(response)
