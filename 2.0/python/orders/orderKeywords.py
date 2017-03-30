from callfire.client import CallfireClient

client = CallfireClient('api-login', 'api-password')
response = client.orders.orderKeywords(
    body={
        'keywords': ['SUN', 'MOON']
    }
).result()

print(response)
