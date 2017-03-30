from callfire.client import CallfireClient

client = CallfireClient('api-login', 'api-password')
response = client.orders.orderNumbers(
    body={
        # order particular numbers
        'numbers': ['12131234567', '12131234568']
        # or find and order area-specific numbers
        # localCount: '2',
        # zipcode: '90401'
    }
).result()

# see sample JSON response for this API
# on 'curl' samples tab
print(response)