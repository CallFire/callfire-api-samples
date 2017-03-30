from callfire.client import CallfireClient

client = CallfireClient('api-login', 'api-password')
response = client.orders.orderKeywords(
    body={
        'keywords': ['SUN', 'MOON']
    }
).result()

# see sample JSON response for this API
# on 'curl' samples tab
print(response)
